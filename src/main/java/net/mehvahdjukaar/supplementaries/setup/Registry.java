package net.mehvahdjukaar.supplementaries.setup;

import com.google.common.collect.Sets;
import net.mehvahdjukaar.supplementaries.Supplementaries;
import net.mehvahdjukaar.supplementaries.blocks.ClockBlock;
import net.mehvahdjukaar.supplementaries.blocks.ClockBlockTile;
import net.mehvahdjukaar.supplementaries.blocks.PlanterBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Supplementaries.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Supplementaries.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Supplementaries.MOD_ID);


    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //planter
    public static final RegistryObject<Block> PLANTER = BLOCKS.register("planter", () -> new PlanterBlock(
            AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .hardnessAndResistance(2f, 6f)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
                    .notSolid()
    ));
    public static final RegistryObject<Item> PLANTER_ITEM = ITEMS.register("planter", () -> new BlockItem(PLANTER.get(),
            new Item.Properties().group(ItemGroup.DECORATIONS)));

    //clock
    public static final RegistryObject<Block> CLOCK_BLOCK = BLOCKS.register("clock_block", () -> new ClockBlock(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .hardnessAndResistance(2f, 6f)
                    .harvestLevel(0)
                    .setRequiresTool()
                    .harvestTool(ToolType.AXE)
                    .notSolid()
    ));
    public static final RegistryObject<TileEntityType<ClockBlockTile>> CLOCK_BLOCK_TILE = TILES.register("clock_block",
            () -> TileEntityType.Builder.create(ClockBlockTile::new, CLOCK_BLOCK.get()).build(null));

    public static final RegistryObject<Item> CLOCK_BLOCK_ITEM = ITEMS.register("clock_block", () -> new BlockItem(CLOCK_BLOCK.get(),
            new Item.Properties().group(ItemGroup.REDSTONE)));


}