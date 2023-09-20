package com.thebulletkin.deepslategalactic.item.custom;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import com.thebulletkin.deepslategalactic.block.custom.ZiplinePillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class ZiplineLauncher extends Item {
    public static final int range = 30;
    private BlockPos playerOnPos;
    private BlockHitResult targetBlock;
    private BlockState ZiplinePillarBlockState = DSGBlocks.ZIPLINE_PILLAR.get().defaultBlockState();

    /**
     * The zipline launcher will have you right click,
     * find the block you are looking at within a certain range,
     * create a zipline pillar at your feet and the block you hit.
     * Then draws a line between them both that can be interacted with.
     *
     *
     */
    public ZiplineLauncher(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide()) {

            targetBlock = CastRay(pLevel, pPlayer, ClipContext.Fluid.NONE);
            playerOnPos = pPlayer.getOnPos();
            if (GroundBelowPlayerIsSuitable(pLevel, playerOnPos) && TargetSurfaceIsSuitable(pLevel)) {
                PlacePillarOnPlayer(pLevel, playerOnPos);

                DeepSlateGalactic.LOGGER.info("Can place on player? " + GroundBelowPlayerIsSuitable(pLevel, playerOnPos));
                DeepSlateGalactic.LOGGER.info("Can place on target? " + TargetSurfaceIsSuitable(pLevel));

                PlacePillarOnTarget(pLevel, GetPosToPlacePillar());
                return InteractionResultHolder.success(itemStack);
            } else {
                return InteractionResultHolder.pass(itemStack);
            }

        }
        else {
            return InteractionResultHolder.pass(itemStack);
        }
        
    }

    private BlockPos GetPosToPlacePillar() {
        return switch (targetBlock.getDirection()) {
            case UP -> targetBlock.getBlockPos().above();
            case EAST -> targetBlock.getBlockPos().east();
            case WEST -> targetBlock.getBlockPos().west();
            case SOUTH -> targetBlock.getBlockPos().south();
            case NORTH -> targetBlock.getBlockPos().north();
            case DOWN -> targetBlock.getBlockPos().below();
        };
    }

    private void PlacePillarOnTarget(Level pLevel, BlockPos blockPos) {

        pLevel.setBlock(blockPos, ZiplinePillarBlockState.setValue(ZiplinePillarBlock.FACING, targetBlock.getDirection()), 3);
    }

    private void PlacePillarOnPlayer(Level pLevel, BlockPos playerOnPos) {
        pLevel.setBlock(playerOnPos.above(), ZiplinePillarBlockState, 3);
    }

    private boolean SpaceBetweenIsUnobstructed() {
        return false;
    }

    private boolean TargetSurfaceIsSuitable(Level pLevel) {
        BlockPos targetBlockPos = targetBlock.getBlockPos();
        BlockState blockHit = pLevel.getBlockState(targetBlockPos);
        return blockHit.isFaceSturdy(pLevel, targetBlockPos, targetBlock.getDirection());
    }

    private boolean GroundBelowPlayerIsSuitable(Level pLevel, BlockPos playerOnPos) {

        BlockState blockStateBelowPlayer = pLevel.getBlockState(playerOnPos);        
        return blockStateBelowPlayer.isFaceSturdy(pLevel, playerOnPos, Direction.UP);
    }

    protected static BlockHitResult CastRay(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode) {
        double range = 30;

        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        Vec3 vec3 = pPlayer.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f4 = -Mth.cos(-f * ((float) Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float) Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;

        Vec3 vec31 = vec3.add((double) f6 * range, (double) f5 * range, (double) f7 * range);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }
}
