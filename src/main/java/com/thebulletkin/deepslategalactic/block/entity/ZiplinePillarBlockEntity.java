package com.thebulletkin.deepslategalactic.block.entity;

import com.sun.jna.WString;
import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ZiplinePillarBlockEntity extends BlockEntity {

    private BlockPos ConnectedPillarPos;
    public static String CONNECTED_PILLAR_POS = "ConnectedPillarPos";


    public ZiplinePillarBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(DSGBlockEntities.ZIPLINE_PILLAR_BE.get(), pPos, pBlockState);



    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put(CONNECTED_PILLAR_POS, NbtUtils.writeBlockPos(ConnectedPillarPos));
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.ConnectedPillarPos = NbtUtils.readBlockPos(pTag);
    }
}
