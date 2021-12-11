
    package com.omicron.verticalslabs.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VerticalEndStoneBrickSlab extends VerticalSlabBase<VerticalEndStoneBrickSlab> {

    public VerticalEndStoneBrickSlab() {
        super(
                Properties.of(Material.STONE)
                        .sound(SoundType.STONE)
                        .strength(3.0f, 6.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(0)
                        .requiresCorrectToolForDrops()
        );
    }


}

    