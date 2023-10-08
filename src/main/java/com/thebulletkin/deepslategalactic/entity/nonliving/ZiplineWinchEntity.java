package com.thebulletkin.deepslategalactic.entity.nonliving;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ZiplineWinchEntity extends Entity {
    private BlockPos startPos;
    private BlockPos destinationPos;
    private boolean hasMoved = false;

    //Smooth Interpolation variables
    protected int lerpSteps;
    protected double lerpX;
    protected double lerpY;
    protected double lerpZ;
    protected double lerpYRot;
    protected double lerpXRot;

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

    public static ZiplineWinchEntity createWinch(Level pLevel, double x, double y, double z) {
        return new ZiplineWinchEntity(pLevel, x, y, z);
    }

    public void setStartPos(BlockPos startPos){
        this.startPos = startPos;
    }
    public void setDestinationPos(BlockPos destinationPos){
        this.destinationPos = destinationPos;
    }

    @Override
    public InteractionResult interact(Player pPlayer, InteractionHand pHand) {
        if (!level().isClientSide()) {
            pPlayer.startRiding(this);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    /**
     * Called by the client packet listener to make interpolated movements
     * Stuff like the minecart calls this, and uses the code snippets below.
     */
    public void lerpTo(double d, double e, double f, float g, float h, int i, boolean bl) {
        this.lerpX = d;
        this.lerpY = e;
        this.lerpZ = f;
        this.lerpYRot = (double)g;
        this.lerpXRot = (double)h;
        this.lerpSteps = i;
    }

    /**
     * Controls the entity movement for each tick
     */
    @Override
    public void tick() {
        super.tick();

        /**
         * Will only perform the following on the server side since entity data is stored there
         * Will turn the destination BlockPos into a vector position,
         *   and gets the square distance from the current location to that destination position.
         * The movement vector will essentially point to where to go on the next tick,
         *   That is found by finding the vector between where this is and the target location vector,
         *   normalise it to a unit vector then scale it.
         * If the distance left to go is less than the square of the tick distance value on the far right,
         *   just jump to the destination rather than go bit by bit.
         */
        if (!level().isClientSide && !hasMoved && destinationPos != null && this.isVehicle()) {
            Vec3 destination = destinationPos.getCenter();
            double distSqr = position().distanceToSqr(destination);
            //The value on the right essentially controls the speed
            Vec3 movement = position().vectorTo(destination).normalize().scale(distSqr < 0.0625 ? Math.sqrt(distSqr) : 0.25);
            //setDeltaMovement(movement);
            move(MoverType.SELF, movement);
            if (distSqr == 0) hasMoved = true;
        }

        /**
         * Will essentially perform sub tick movements using the lerp values allocated above
         *   to ensure smooth movements on each tick.
         * Found in living entity
         */
        if (!isRemoved() && lerpSteps > 0) {
            double d0 = getX() + (lerpX - getX()) / (double) lerpSteps;
            double d2 = getY() + (lerpY - getY()) / (double) lerpSteps;
            double d4 = getZ() + (lerpZ - getZ()) / (double) lerpSteps;
            double d6 = Mth.wrapDegrees(lerpYRot - (double) getYRot());
            setYRot(getYRot() + (float) d6 / (float) lerpSteps);
            setXRot(getXRot() + (float) (lerpXRot - (double) getXRot()) / (float) lerpSteps);
            --lerpSteps;
            setPos(d0, d2, d4);
            setRot(getYRot(), getXRot());
        }
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        if (tag.contains("DestinationPos")) destinationPos = NbtUtils.readBlockPos(tag.getCompound("DestinationPos"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        if (destinationPos != null) tag.put("DestinationPos", NbtUtils.writeBlockPos(destinationPos));
    }
}
