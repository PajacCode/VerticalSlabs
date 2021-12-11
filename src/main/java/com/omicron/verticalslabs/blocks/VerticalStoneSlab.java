
    package com.omicron.verticalslabs.blocks;

import com.omicron.verticalslabs.items.VerticalStoneSlabItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class VerticalStoneSlab extends VerticalSlabBase<VerticalStoneSlab> {

    public VerticalStoneSlab() {
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

    