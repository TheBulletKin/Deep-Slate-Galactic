package com.thebulletkin.deepslategalactic.entity.nonliving;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ZiplineWinchEntity extends Entity {


    public ZiplineWinchEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ZiplineWinchEntity(Level pLevel, double pX, double pY, double pZ){
        this(DSGEntities.ZIPLINE_WINCH.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    public static ZiplineWinchEntity createWinch(Level pLevel, int x, int y, int z) {
        return new ZiplineWinchEntity(pLevel, x, y, z);

    }

    @Override
    public InteractionResult interact(Player pPlayer, InteractionHand pHand) {
        DeepSlateGalactic.LOGGER.info("interacted with");

        if (!level().isClientSide()) {
            pPlayer.startRiding(this);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }
}
