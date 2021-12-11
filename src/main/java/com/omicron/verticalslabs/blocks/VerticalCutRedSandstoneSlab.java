
    package com.omicron.verticalslabs.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VerticalCutRedSandstoneSlab extends VerticalSlabBase<VerticalCutRedSandstoneSlab> {

    public VerticalCutRedSandstoneSlab() {
        super(
                Properties.of(Material.STONE)
                        .sound(SoundType.STONE)
                        .strength(2.0f, 6.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(0)
                        .requiresCorrectToolForDrops()
        );
    }


}

    