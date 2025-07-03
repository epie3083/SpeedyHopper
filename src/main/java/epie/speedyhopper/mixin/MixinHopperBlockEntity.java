package epie.speedyhopper.mixin;

import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(HopperBlockEntity.class)
public abstract class MixinHopperBlockEntity {
    @ModifyConstant(
            method = "tryMoveItems(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/HopperBlockEntity;Ljava/util/function/BooleanSupplier;)Z",
            constant = @Constant(intValue = 8)
    )
    private static int onTryMoveItemsCooldown(int original) {
        return 1;
    }

    @ModifyConstant(
            method = "tryMoveInItem(Lnet/minecraft/world/Container;Lnet/minecraft/world/Container;Lnet/minecraft/world/item/ItemStack;ILnet/minecraft/core/Direction;)Lnet/minecraft/world/item/ItemStack;",
            constant = @Constant(intValue = 8)
    )
    private static int onTryMoveInItemCooldown(int original) {
        return 1;
    }
}
