package net.dugged.cleancuteless;

import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MODID, category = "")
public final class Configuration {
	public static final General general = new General();
	public static final Visuals visuals = new Visuals();
	public static final Rendering rendering = new Rendering();
	public static final Player player = new Player();
	public static final Building building = new Building();
	public static final Ui ui = new Ui();
	public static final Network network = new Network();
	public static final Fixes fixes = new Fixes();

	private Configuration() {
	}

	public static final class General {
		@Config.RequiresMcRestart
		@Config.Comment("Generate a keybind for each toggle on the next launch.")
		public boolean autoGenerateKeybinds = false;
		public boolean singleplayerCheats = false;
	}

	public static final class Visuals {
		@Config.Comment("Show daytime on the client without changing server time.")
		public boolean forceDaytime = false;
		public boolean colorfulFireworkTrails = false;
		@Config.Comment("Tilt chickens and endermen for the derpy visual effect.")
		public boolean tiltedMobs = false;
		public boolean showArmor = true;
		@Config.RequiresMcRestart
		public boolean showBarrierBlocks = false;
		public boolean showBlockBreakingParticles = true;
		public boolean showBlockSelectorUnderwater = false;
		public boolean showCenteredPlants = false;
		public boolean showClearLava = false;
		public boolean showDamageTilt = false;
		public boolean showDeathAnimations = true;
		public boolean showDeathParticles = true;
		public boolean showGuiBackground = true;
		public boolean showHand = true;
		public boolean showHandChangeAnimation = true;
		public boolean showIdealToolMarker = false;
		@Config.Comment("Draw the item frame border around displayed items.")
		public boolean showItemFrameBorder = true;
		public boolean showMoreEndPortalFaces = false;
		public boolean showPotionShift = true;
		public boolean showRain = true;
		public boolean showRainbowLeaves = false;
		public boolean showRandomTextures = true;
		public boolean showShulkerContents = false;
		public boolean smoothWaterLighting = false;
		public boolean showSneakEyeHeight = false;
		public boolean showSnowDripParticles = false;
		public boolean showSpectatorTeamMenu = true;
		public boolean showWorldBobbing = true;
		public boolean showWorldFog = true;
		public boolean waterAffectsFov = true;
		@Config.SlidingOption
		@Config.RangeDouble(min = 0D, max = 3D)
		public double blockBreakParticleScale = 1D;
		public boolean stackedEntityCounts = false;
	}

	public static final class Rendering {
		@Config.Comment("Render tile entities regardless of distance.")
		public boolean renderAllTileEntities = false;
		@Config.RequiresMcRestart
		@Config.Comment("Render chests as block models instead of tile entities.")
		public boolean renderChestsWithBlockModels = false;
		public boolean lightUpdates = true;
		@Config.Comment("Skip item frames outside the camera view.")
		public boolean cullHiddenItemFrames = false;
		@Config.Comment("Skip cave mood sounds and their light checks.")
		public boolean disableCaveAmbience = false;
	}

	public static final class Player {
		@Config.Comment("Update non-player entities on the client.")
		public boolean updateClientEntities = true;
		@Config.Comment("Shift+Ctrl-click a recipe to craft all available items.")
		public boolean quickCraftAll = true;
		@Config.Comment("Shift+Space cancels elytra flight.")
		public boolean cancelElytraFlight = false;
		@Config.Comment("Stop horizontal drift when releasing flight controls.")
		public boolean cancelFlightInertia = false;
		public boolean jumpBoostStepAssist = false;
		public boolean lockYaw = false;
		public boolean noClip = false;
		public boolean noFall = false;
		public boolean respawnOnDeath = false;
		@Config.Comment("Block firework use while its cooldown is active.")
		public boolean enforceRocketCooldown = false;
		@Config.SlidingOption
		@Config.RangeDouble(min = 0D, max = 1D)
		public double spectatorFlightSpeed = 0.2;
		public boolean stepAssist = false;
		public boolean smoothItemMovement = false;
	}

	public static final class Building {
		public boolean pickBlockMaxStack = false;
		@Config.Comment("Reset the post-break delay immediately.")
		public boolean noBlockBreakDelay = false;
		public boolean extendedCreativeHotbar = false;
		public boolean ignoreAirHotbarSnapshots = false;
		@Config.Comment("Skip the double-retraction animation on the client.")
		public boolean instantPistonDoubleRetraction = false;
		@Config.Comment("Show piston movement order and counts.")
		public boolean showPistonOrder = false;
		@Config.Comment("Smooth piston movement on the client.")
		public boolean smoothPistons = false;
		public boolean worldEditCompass = false;
		@Config.RangeInt(min = 0)
		@Config.Comment("Ticks between right-click actions.")
		public int rightClickDelayTicks = 4;
	}

	public static final class Ui {
		@Config.Comment("Show server ping in the server list.")
		public boolean showPing = false;
		@Config.Comment("Shift-click a chat line to copy it.")
		public boolean copyChatOnClick = false;
		@Config.Comment("Print death coordinates to chat.")
		public boolean showDeathLocation = false;
		public boolean hideRealmsButton = false;
		public boolean extendedChat = false;
		@Config.RangeInt(min = 0)
		@Config.Comment("Seconds before automatically reconnecting.")
		public int reconnectDelaySeconds = 10;
		public boolean showItemAttributes = true;
		@Config.Comment("Show only the first boss bar.")
		public boolean showSingleBossBar = false;
		@Config.Comment("Show the scoreboard sidebar.")
		public boolean showScoreboard = true;
		public boolean showServerNames = true;
		public boolean sortEnchantments = false;
	}

	public static final class Network {
		@Config.Comment("Send Carpet-compatible placement rotations.")
		public boolean carpetAccuratePlacement = false;
		@Config.Comment("Refresh pings for visible servers every 15 seconds.")
		public boolean refreshServerListPings = false;
		@Config.Comment("Ignore incoming block-action events.")
		public boolean ignoreBlockEvents = false;
	}

	public static final class Fixes {
		public boolean fixElytraDeploy = false;
		public boolean fixPistonBreakParticles = false;
		public boolean fixObserverFire = false;
		public boolean fixMiningGhostBlocks = false;
		public boolean fixLinuxShiftNumberKeys = false;
		public boolean fixItemStitchingSeams = false;
	}
}
