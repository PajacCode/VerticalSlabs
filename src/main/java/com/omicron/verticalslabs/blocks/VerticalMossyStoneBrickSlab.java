
    package com.omicron.verticalslabs.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VerticalMossyStoneBrickSlab extends VerticalSlabBase<VerticalMossyStoneBrickSlab> {

    public VerticalMossyStoneBrickSlab() {
        super(
                Properties.of(Material.STONE)
                        .sound(SoundType.STONE)
                        .strength(1.5f, 6.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(0)
                        .requiresCorrectToolForDrops()
        );
    }


}

    