package com.thebulletkin.deepslategalactic.entity.nonliving;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class ZiplineWinchEntity extends Entity{


    public ZiplineWinchEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ZiplineWinchEntity(Level pLevel, double pX, double pY, double pZ) {
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
        if (!pPlayer.isShiftKeyDown()) {
            if (pPlayer.getVehicle() != this) {
                if (!level().isClientSide) {
                    pPlayer.startRiding(this);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;

    }



    protected void beginRiding(Player pPlayer){
        pPlayer.setYRot(this.getYRot());
        pPlayer.setXRot(this.getXRot());
        pPlayer.startRiding(this);
    }



    @Override
    public double getPassengersRidingOffset() {
        return 0D;
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
