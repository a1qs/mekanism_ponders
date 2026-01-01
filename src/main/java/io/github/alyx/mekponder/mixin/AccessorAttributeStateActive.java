package io.github.alyx.mekponder.mixin;

import mekanism.common.block.attribute.AttributeStateActive;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = AttributeStateActive.class, remap = false)
public interface AccessorAttributeStateActive {

    @Accessor("activeProperty")
    BooleanProperty mekanism_ponder$getActiveProperty();

}
