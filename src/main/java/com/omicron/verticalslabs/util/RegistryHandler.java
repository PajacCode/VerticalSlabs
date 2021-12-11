package com.omicron.verticalslabs.util;

import com.omicron.verticalslabs.VerticalSlabs;
import com.omicron.verticalslabs.blocks.*;
import com.omicron.verticalslabs.items.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VerticalSlabs.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VerticalSlabs.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Blocks

    public static final RegistryObject<Block> VERTICAL_OAK_SLAB = BLOCKS.register("vertical_oak_slab", VerticalOakSlab::new);
    public static final RegistryObject<Block> VERTICAL_SPRUCE_SLAB = BLOCKS.register("vertical_spruce_slab", VerticalSpruceSlab::new);
    public static final RegistryObject<Block> VERTICAL_BIRCH_SLAB = BLOCKS.register("vertical_birch_slab", VerticalBirchSlab::new);
    public static final RegistryObject<Block> VERTICAL_JUNGLE_SLAB = BLOCKS.register("vertical_jungle_slab", VerticalJungleSlab::new);
    public static final RegistryObject<Block> VERTICAL_ACACIA_SLAB = BLOCKS.register("vertical_acacia_slab", VerticalAcaciaSlab::new);
    public static final RegistryObject<Block> VERTICAL_DARK_OAK_SLAB = BLOCKS.register("vertical_dark_oak_slab", VerticalDarkOakSlab::new);
    public static final RegistryObject<Block> VERTICAL_CRIMSON_SLAB = BLOCKS.register("vertical_crimson_slab", VerticalCrimsonSlab::new);
    public static final RegistryObject<Block> VERTICAL_WARPED_SLAB = BLOCKS.register("vertical_warped_slab", VerticalWarpedSlab::new);
    public static final RegistryObject<Block> VERTICAL_STONE_SLAB = BLOCKS.register("vertical_stone_slab", VerticalStoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_SMOOTH_STONE_SLAB = BLOCKS.register("vertical_smooth_stone_slab", VerticalSmoothStoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_COBBLESTONE_SLAB = BLOCKS.register("vertical_cobblestone_slab", VerticalCobblestoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_MOSSY_COBBLESTONE_SLAB = BLOCKS.register("vertical_mossy_cobblestone_slab", VerticalMossyCobblestoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_STONE_BRICK_SLAB = BLOCKS.register("vertical_stone_brick_slab", VerticalStoneBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_MOSSY_STONE_BRICK_SLAB = BLOCKS.register("vertical_mossy_stone_brick_slab", VerticalMossyStoneBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_ANDESITE_SLAB = BLOCKS.register("vertical_andesite_slab", VerticalAndesiteSlab::new);
    public static final RegistryObject<Block> VERTICAL_POLISHED_ANDESITE_SLAB = BLOCKS.register("vertical_polished_andesite_slab", VerticalPolishedAndesiteSlab::new);
    public static final RegistryObject<Block> VERTICAL_DIORITE_SLAB = BLOCKS.register("vertical_diorite_slab", VerticalDioriteSlab::new);
    public static final RegistryObject<Block> VERTICAL_POLISHED_DIORITE_SLAB = BLOCKS.register("vertical_polished_diorite_slab", VerticalPolishedDioriteSlab::new);
    public static final RegistryObject<Block> VERTICAL_GRANITE_SLAB = BLOCKS.register("vertical_granite_slab", VerticalGraniteSlab::new);
    public static final RegistryObject<Block> VERTICAL_POLISHED_GRANITE_SLAB = BLOCKS.register("vertical_polished_granite_slab", VerticalPolishedGraniteSlab::new);
    public static final RegistryObject<Block> VERTICAL_SANDSTONE_SLAB = BLOCKS.register("vertical_sandstone_slab", VerticalSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_CUT_SANDSTONE_SLAB = BLOCKS.register("vertical_cut_sandstone_slab", VerticalCutSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_SMOOTH_SANDSTONE_SLAB = BLOCKS.register("vertical_smooth_sandstone_slab", VerticalSmoothSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_red_sandstone_slab", VerticalRedSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_CUT_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_cut_red_sandstone_slab", VerticalCutRedSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_smooth_red_sandstone_slab", VerticalSmoothRedSandstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_BRICK_SLAB = BLOCKS.register("vertical_brick_slab", VerticalBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_PRISMARINE_SLAB = BLOCKS.register("vertical_prismarine_slab", VerticalPrismarineSlab::new);
    public static final RegistryObject<Block> VERTICAL_PRISMARINE_BRICK_SLAB = BLOCKS.register("vertical_prismarine_brick_slab", VerticalPrismarineBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_DARK_PRISMARINE_SLAB = BLOCKS.register("vertical_dark_prismarine_slab", VerticalDarkPrismarineSlab::new);
    public static final RegistryObject<Block> VERTICAL_NETHER_BRICK_SLAB = BLOCKS.register("vertical_nether_brick_slab", VerticalNetherBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_RED_NETHER_BRICK_SLAB = BLOCKS.register("vertical_red_nether_brick_slab", VerticalRedNetherBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_QUARTZ_SLAB = BLOCKS.register("vertical_quartz_slab", VerticalQuartzSlab::new);
    public static final RegistryObject<Block> VERTICAL_SMOOTH_QUARTZ_SLAB = BLOCKS.register("vertical_smooth_quartz_slab", VerticalSmoothQuartzSlab::new);
    public static final RegistryObject<Block> VERTICAL_PURPUR_SLAB = BLOCKS.register("vertical_purpur_slab", VerticalPurpurSlab::new);
    public static final RegistryObject<Block> VERTICAL_END_STONE_BRICK_SLAB = BLOCKS.register("vertical_end_stone_brick_slab", VerticalEndStoneBrickSlab::new);
    public static final RegistryObject<Block> VERTICAL_BLACKSTONE_SLAB = BLOCKS.register("vertical_blackstone_slab", VerticalBlackstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_POLISHED_BLACKSTONE_SLAB = BLOCKS.register("vertical_polished_blackstone_slab", VerticalPolishedBlackstoneSlab::new);
    public static final RegistryObject<Block> VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = BLOCKS.register("vertical_polished_blackstone_brick_slab", VerticalPolishedBlackstoneBrickSlab::new);



    //VerticalSlabBlockItems
    public static final RegistryObject<Item> VERTICAL_OAK_SLAB_ITEM = ITEMS.register("vertical_oak_slab",
            VerticalOakSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SPRUCE_SLAB_ITEM = ITEMS.register("vertical_spruce_slab",
            VerticalSpruceSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_BIRCH_SLAB_ITEM = ITEMS.register("vertical_birch_slab",
            VerticalBirchSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_JUNGLE_SLAB_ITEM = ITEMS.register("vertical_jungle_slab",
            VerticalJungleSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_ACACIA_SLAB_ITEM = ITEMS.register("vertical_acacia_slab",
            VerticalAcaciaSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_DARK_OAK_SLAB_ITEM = ITEMS.register("vertical_dark_oak_slab",
            VerticalDarkOakSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_CRIMSON_SLAB_ITEM = ITEMS.register("vertical_crimson_slab",
            VerticalCrimsonSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_WARPED_SLAB_ITEM = ITEMS.register("vertical_warped_slab",
            VerticalWarpedSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_STONE_SLAB_ITEM = ITEMS.register("vertical_stone_slab",
            VerticalStoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SMOOTH_STONE_SLAB_ITEM = ITEMS.register("vertical_smooth_stone_slab",
            VerticalSmoothStoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_COBBLESTONE_SLAB_ITEM = ITEMS.register("vertical_cobblestone_slab",
            VerticalCobblestoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_MOSSY_COBBLESTONE_SLAB_ITEM = ITEMS.register("vertical_mossy_cobblestone_slab",
            VerticalMossyCobblestoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_stone_brick_slab",
            VerticalStoneBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_MOSSY_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_mossy_stone_brick_slab",
            VerticalMossyStoneBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_ANDESITE_SLAB_ITEM = ITEMS.register("vertical_andesite_slab",
            VerticalAndesiteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_POLISHED_ANDESITE_SLAB_ITEM = ITEMS.register("vertical_polished_andesite_slab",
            VerticalPolishedAndesiteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_DIORITE_SLAB_ITEM = ITEMS.register("vertical_diorite_slab",
            VerticalDioriteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_POLISHED_DIORITE_SLAB_ITEM = ITEMS.register("vertical_polished_diorite_slab",
            VerticalPolishedDioriteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_GRANITE_SLAB_ITEM = ITEMS.register("vertical_granite_slab",
            VerticalGraniteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_POLISHED_GRANITE_SLAB_ITEM = ITEMS.register("vertical_polished_granite_slab",
            VerticalPolishedGraniteSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_sandstone_slab",
            VerticalSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_CUT_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_cut_sandstone_slab",
            VerticalCutSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SMOOTH_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_smooth_sandstone_slab",
            VerticalSmoothSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_red_sandstone_slab",
            VerticalRedSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_CUT_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_cut_red_sandstone_slab",
            VerticalCutRedSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SMOOTH_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_smooth_red_sandstone_slab",
            VerticalSmoothRedSandstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_BRICK_SLAB_ITEM = ITEMS.register("vertical_brick_slab",
            VerticalBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_PRISMARINE_SLAB_ITEM = ITEMS.register("vertical_prismarine_slab",
            VerticalPrismarineSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_PRISMARINE_BRICK_SLAB_ITEM = ITEMS.register("vertical_prismarine_brick_slab",
            VerticalPrismarineBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_DARK_PRISMARINE_SLAB_ITEM = ITEMS.register("vertical_dark_prismarine_slab",
            VerticalDarkPrismarineSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_NETHER_BRICK_SLAB_ITEM = ITEMS.register("vertical_nether_brick_slab",
            VerticalNetherBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_RED_NETHER_BRICK_SLAB_ITEM = ITEMS.register("vertical_red_nether_brick_slab",
            VerticalRedNetherBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_QUARTZ_SLAB_ITEM = ITEMS.register("vertical_quartz_slab",
            VerticalQuartzSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_SMOOTH_QUARTZ_SLAB_ITEM = ITEMS.register("vertical_smooth_quartz_slab",
            VerticalSmoothQuartzSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_PURPUR_SLAB_ITEM = ITEMS.register("vertical_purpur_slab",
            VerticalPurpurSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_END_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_end_stone_brick_slab",
            VerticalEndStoneBrickSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_BLACKSTONE_SLAB_ITEM = ITEMS.register("vertical_blackstone_slab",
            VerticalBlackstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_POLISHED_BLACKSTONE_SLAB_ITEM = ITEMS.register("vertical_polished_blackstone_slab",
            VerticalPolishedBlackstoneSlabItem::new);
    public static final RegistryObject<Item> VERTICAL_POLiSHED_BLACKSTONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_polished_blackstone_brick_slab",
            VerticalPolishedBlackstoneBrickSlabItem::new);



}
