package com.thebulletkin.deepslategalactic.entity.nonliving.projectile;

import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PlatformProjectileEntity extends ThrowableItemProjectile {
    private static BlockState platformBlockState = DSGBlocks.PLATFORM_BLOCK.get().defaultBlockState();
    public PlatformProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PlatformProjectileEntity(Level pLevel) {
        this(DSGEntities.PLATFORM_PROJECTILE.get(), pLevel);
    }

    public PlatformProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(DSGEntities.PLATFORM_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        placeBlocksAroundOrigin(getBlockPosOffset(pResult.getBlockPos(), pResult.getDirection()));
    }

    private void replaceBlockWithPlatform(BlockPos blockPos) {
        this.level().setBlock(blockPos, platformBlockState, 3);
    }

    private void placeBlocksAroundOrigin(BlockPos blockPos){
        BlockPos rowPos = blockPos.north().west();
        BlockPos columnPos = rowPos;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                replaceBlockWithPlatform(columnPos);
                columnPos = columnPos.east();
            }
            rowPos = rowPos.south();
            columnPos = rowPos;
        }
        this.discard();
    }

    private BlockPos getBlockPosOffset(BlockPos blockPos, Direction faceDirection){
        switch (faceDirection){
            case UP :
                return blockPos.above();
            case DOWN :
                return blockPos.below();
            case EAST :
                return blockPos.east().east();
            case WEST :
                return blockPos.west().west();
            case NORTH :
                return blockPos.north().north();
            case SOUTH :
                return blockPos.south().south();
            default:
                return null;
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }


}
