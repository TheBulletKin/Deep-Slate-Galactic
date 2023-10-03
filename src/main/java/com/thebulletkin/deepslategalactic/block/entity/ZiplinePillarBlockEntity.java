package com.thebulletkin.deepslategalactic.block.entity;

import com.sun.jna.WString;
import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.custom.ZiplinePillarBlock;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ZiplinePillarBlockEntity extends BlockEntity {

    private BlockPos ConnectedPillarPos;
    public static String CONNECTED_PILLAR_POS_TAG = "ConnectedPillarPos";


    protected ZiplinePillarBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public ZiplinePillarBlockEntity(BlockPos pPos, BlockState pBlockState){
        this(DSGBlockEntities.ZIPLINE_PILLAR_BE.get(), pPos, pBlockState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (this.ConnectedPillarPos != null){
            pTag.put(CONNECTED_PILLAR_POS_TAG, NbtUtils.writeBlockPos(this.ConnectedPillarPos));
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.ConnectedPillarPos = NbtUtils.readBlockPos(pTag.getCompound("ConnectedPillarPos"));
    }

    public BlockPos getConnectedPillarPos(){
        return this.ConnectedPillarPos;
    }

    public void setConnectedPillarPos(BlockPos pPos){
        this.ConnectedPillarPos = pPos;
    }
}
