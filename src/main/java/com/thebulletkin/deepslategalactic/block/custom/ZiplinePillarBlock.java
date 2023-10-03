package com.thebulletkin.deepslategalactic.block.custom;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.entity.ZiplinePillarBlockEntity;
import com.thebulletkin.deepslategalactic.entity.nonliving.ZiplineWinchEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;

public class ZiplinePillarBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected static final VoxelShape SHAPE = Block.box(6D, 0D, 6D, 10D, 32D, 10D);

    public ZiplinePillarBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ZiplinePillarBlockEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(direction.getOpposite()));
        return this.defaultBlockState().setValue(FACING, pContext.getClickedFace());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND){

            ZiplineWinchEntity ziplinewinchentity = ZiplineWinchEntity.createWinch(pLevel, pPos.getX(), pPos.getY(), pPos.getZ());
            pLevel.addFreshEntity(ziplinewinchentity);

            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ZiplinePillarBlockEntity ziplinePillarBlockEntity){

                pPlayer.teleportTo(ziplinePillarBlockEntity.getConnectedPillarPos().getX(), ziplinePillarBlockEntity.getConnectedPillarPos().getY(), ziplinePillarBlockEntity.getConnectedPillarPos().getZ());
            }

            return InteractionResult.SUCCESS;
        }
        else {
            return InteractionResult.FAIL;
        }
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.setValue(FACING, pMirror.mirror(pState.getValue(FACING)));
    }
}
