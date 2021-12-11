package com.omicron.verticalslabs.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VerticalBirchSlab extends VerticalSlabBase<VerticalBirchSlab> {

    public VerticalBirchSlab() {
        super(
                Properties.of(Material.WOOD)
                        .strength(2.0f, 3.0f)
                        .harvestTool(ToolType.AXE)
                        .sound(SoundType.WOOD)
        );
    }


}
