package com.greybeetle.sitelen_pona;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("sitelen_pona")
public class sitelen_pona
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static String[] TokiPonaLatin = {" a "," akesi ", " ala ", " alasa ", " ali ", " anpa ", " ante ", " anu ", " awen ", " e ", " en ", " esun ", " ijo ", " ike ", " ilo ", " insa ", " jaki ", " jan ", " jelo ", " jo ", " kala ", " kalama ", " kama ", " kasi ", " ken ", " kepeken ", " kili ", " kiwen ", " ko ", " kon ", " kule ", " kulupu ", " kute ", " la ", " lape ", " laso ", " lawa ", " len ", " lete ", " li ", " lili ", " linja ", " lipu ", " loje ", " lon ", " luka ", " lukin ", " lupa ", " ma ", " mama ", " mani ", " meli ", " mi ", " mije ", " moku ", " moli ", " monsi ", " mu ", " mun ", " musi ", " mute ", " nanpa ", " nasa ", " nasin ", " nena ", " ni ", " nimi ", " noka ", " o ", " olin ", " ona ", " open ", " pakala ", " pali ", " palisa ", " pan ", " pana ", " pi ", " pilin ", " pimeja ", " pini ", " pipi ", " poka ", " poki ", " pona ", " pu ", " sama ", " seli ", " selo ", " seme ", " sewi ", " sijelo ", " sike ", " sin ", " sina ", " sinpin ", " sitelen ", " sona ", " soweli ", " suli ", " suno ", " supa ", " suwi ", " tan ", " taso ", " tawa ", " telo ", " tenpo ", " toki ", " tomo ", " tu ", " unpa ", " uta ", " utala ", " walo ", " wan ", " waso ", " wawa ", " weka ", " wile ", " namako ", " kin ", " oko ", " kipisi ", " leko ", " monsuta ", " tonsi ", " jasima ", " kijetesuntakalo ", " soko ", " meso "};

    public static String[] TokiPonaSitelen = {"\uDB86\uDD00", "\uDB86\uDD01", "\uDB86\uDD02", "\uDB86\uDD03", "\uDB86\uDD04", "\uDB86\uDD05", "\uDB86\uDD06", "\uDB86\uDD07", "\uDB86\uDD08", "\uDB86\uDD09", "\uDB86\uDD0A", "\uDB86\uDD0B", "\uDB86\uDD0C", "\uDB86\uDD0D", "\uDB86\uDD0E", "\uDB86\uDD0F", "\uDB86\uDD10", "\uDB86\uDD11", "\uDB86\uDD12", "\uDB86\uDD13", "\uDB86\uDD14", "\uDB86\uDD15", "\uDB86\uDD16", "\uDB86\uDD17", "\uDB86\uDD18", "\uDB86\uDD19", "\uDB86\uDD1A", "\uDB86\uDD1B", "\uDB86\uDD1C", "\uDB86\uDD1D", "\uDB86\uDD1E", "\uDB86\uDD1F", "\uDB86\uDD20", "\uDB86\uDD21", "\uDB86\uDD22", "\uDB86\uDD23", "\uDB86\uDD24", "\uDB86\uDD25", "\uDB86\uDD26", "\uDB86\uDD27", "\uDB86\uDD28", "\uDB86\uDD29", "\uDB86\uDD2A", "\uDB86\uDD2B", "\uDB86\uDD2C", "\uDB86\uDD2D", "\uDB86\uDD2E", "\uDB86\uDD2F", "\uDB86\uDD30", "\uDB86\uDD31", "\uDB86\uDD32", "\uDB86\uDD33", "\uDB86\uDD34", "\uDB86\uDD35", "\uDB86\uDD36", "\uDB86\uDD37", "\uDB86\uDD38", "\uDB86\uDD39", "\uDB86\uDD3A", "\uDB86\uDD3B", "\uDB86\uDD3C", "\uDB86\uDD3D", "\uDB86\uDD3E", "\uDB86\uDD3F", "\uDB86\uDD40", "\uDB86\uDD41", "\uDB86\uDD42", "\uDB86\uDD43", "\uDB86\uDD44", "\uDB86\uDD45", "\uDB86\uDD46", "\uDB86\uDD47", "\uDB86\uDD48", "\uDB86\uDD49", "\uDB86\uDD4A", "\uDB86\uDD4B", "\uDB86\uDD4C", "\uDB86\uDD4D", "\uDB86\uDD4E", "\uDB86\uDD4F", "\uDB86\uDD50", "\uDB86\uDD51", "\uDB86\uDD52", "\uDB86\uDD53", "\uDB86\uDD54", "\uDB86\uDD55", "\uDB86\uDD56", "\uDB86\uDD57", "\uDB86\uDD58", "\uDB86\uDD59", "\uDB86\uDD5A", "\uDB86\uDD5B", "\uDB86\uDD5C", "\uDB86\uDD5D", "\uDB86\uDD5E", "\uDB86\uDD5F", "\uDB86\uDD60", "\uDB86\uDD61", "\uDB86\uDD62", "\uDB86\uDD63", "\uDB86\uDD64", "\uDB86\uDD65", "\uDB86\uDD66", "\uDB86\uDD67", "\uDB86\uDD68", "\uDB86\uDD69", "\uDB86\uDD6A", "\uDB86\uDD6B", "\uDB86\uDD6C", "\uDB86\uDD6D", "\uDB86\uDD6E", "\uDB86\uDD6F", "\uDB86\uDD70", "\uDB86\uDD71", "\uDB86\uDD72", "\uDB86\uDD73", "\uDB86\uDD74", "\uDB86\uDD75", "\uDB86\uDD76", "\uDB86\uDD77", "\uDB86\uDD78", "\uDB86\uDD79", "\uDB86\uDD7A", "\uDB86\uDD7B", "\uDB86\uDD7C", "\uDB86\uDD7D", "\uDB86\uDD7E", "\uDB86\uDD7F","\uDB86\uDD80", "\uDB86\uDD81", "\uDB86\uDD82", "\uDB86\uDD83", "\uDB86\uDD84", "\uDB86\uDD85", "\uDB86\uDD86", "\uDB86\uDD87", "\uDB86\uDD88", "\uDB86\uDD89", "\uDB86\uDD8A", "\uDB86\uDD8B", "\uDB86\uDD8C", "\uDB86\uDD8D", "\uDB86\uDD8E", "\uDB86\uDD8F", "\uDB86\uDD90", "\uDB86\uDD91", "\uDB86\uDD92", "\uDB86\uDD93", "\uDB86\uDD94", "\uDB86\uDD95", "\uDB86\uDD96", "\uDB86\uDD97", "\uDB86\uDD98", "\uDB86\uDD99", "\uDB86\uDD9A", "\uDB86\uDD9B", "\uDB86\uDD9C", "\uDB86\uDD9D", "\uDB86\uDD9E", "\uDB86\uDD9F", "\uDB86\uDDA0", "\uDB86\uDDA1", "\uDB86\uDDA2", "\uDB86\uDDA3", "\uDB86\uDDA4", "\uDB86\uDDA5", "\uDB86\uDDA6", "\uDB86\uDDA7", "\uDB86\uDDA8", "\uDB86\uDDA9", "\uDB86\uDDAA", "\uDB86\uDDAB", "\uDB86\uDDAC", "\uDB86\uDDAD", "\uDB86\uDDAE", "\uDB86\uDDAF", "\uDB86\uDDB0", "\uDB86\uDDB1", "\uDB86\uDDB2", "\uDB86\uDDB3", "\uDB86\uDDB4", "\uDB86\uDDB5", "\uDB86\uDDB6", "\uDB86\uDDB7", "\uDB86\uDDB8", "\uDB86\uDDB9", "\uDB86\uDDBA", "\uDB86\uDDBB", "\uDB86\uDDBC", "\uDB86\uDDBD", "\uDB86\uDDBE", "\uDB86\uDDBF", "\uDB86\uDDC0", "\uDB86\uDDC1", "\uDB86\uDDC2", "\uDB86\uDDC3", "\uDB86\uDDC4", "\uDB86\uDDC5", "\uDB86\uDDC6", "\uDB86\uDDC7", "\uDB86\uDDC8", "\uDB86\uDDC9", "\uDB86\uDDCA", "\uDB86\uDDCB", "\uDB86\uDDCC", "\uDB86\uDDCD", "\uDB86\uDDCE", "\uDB86\uDDCF", "\uDB86\uDDD0", "\uDB86\uDDD1", "\uDB86\uDDD2", "\uDB86\uDDD3", "\uDB86\uDDD4", "\uDB86\uDDD5", "\uDB86\uDDD6", "\uDB86\uDDD7", "\uDB86\uDDD8", "\uDB86\uDDD9", "\uDB86\uDDDA", "\uDB86\uDDDB", "\uDB86\uDDDC", "\uDB86\uDDDD", "\uDB86\uDDDE", "\uDB86\uDDDF", "\uDB86\uDDE0", "\uDB86\uDDE1", "\uDB86\uDDE2", "\uDB86\uDDE3", "\uDB86\uDDE4", "\uDB86\uDDE5", "\uDB86\uDDE6", "\uDB86\uDDE7", "\uDB86\uDDE8", "\uDB86\uDDE9", "\uDB86\uDDEA", "\uDB86\uDDEB", "\uDB86\uDDEC", "\uDB86\uDDED", "\uDB86\uDDEE", "\uDB86\uDDEF ", "\uDB86\uDDF0", "\uDB86\uDDF1", "\uDB86\uDDF2", "\uDB86\uDDF3", "\uDB86\uDDF4", "\uDB86\uDDF5", "\uDB86\uDDF6", "\uDB86\uDDF7", "\uDB86\uDDF8", "\uDB86\uDDF9", "\uDB86\uDDFA", "\uDB86\uDDFB", "\uDB86\uDDFC", "\uDB86\uDDFD", "\uDB86\uDDFE", "\uDB86\uDDFF"};


    public sitelen_pona() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register ourselves for server and other game events we are interested in
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, OctalClientConfigs.SPEC, "octal-client.toml");
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
