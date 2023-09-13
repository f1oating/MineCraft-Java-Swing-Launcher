package back;

import java.util.ArrayList;
import java.util.List;

public class Launch {
	
	private String pcName = System.getProperty("user.name");

	
	public void launchMineCraft(String userName, String version) throws Exception{
			
			List<String> command = new ArrayList<>();
			
			String gameDir = String.format("C:\\Users\\%s\\.f1oatingMineCraft\\instances\\%s", pcName ,version);
			String assetsDir = String.format("C:\\Users\\%s\\.f1oatingMineCraft\\assets", pcName);
			
			String cp = 
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\minecraft\\launchwrapper\\1.11\\launchwrapper-1.11.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\sf\\jopt-simple\\jopt-simple\\4.6\\jopt-simple-4.6.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\ow2\\asm\\asm-all\\4.1\\asm-all-4.1.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\java\\jinput\\jinput\\2.0.5\\jinput-2.0.5.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\java\\jutils\\jutils\\1.0.0\\jutils-1.0.0.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\2.9.1\\lwjgl-2.9.1.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl_util\\2.9.1\\lwjgl_util-2.9.1.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.0-beta9\\log4j-api-2.0-beta9.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.0-beta9\\log4j-core-2.0-beta9.jar;", pcName) +
					String.format("C:\\Users\\%s\\.f1oatingMineCraft\\versions\\%s\\%s.jar", pcName ,version, version);
			
			
			
			command.add(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\jre\\jdk8u382-b05-jre\\bin\\java.exe", pcName));
			command.add(String.format("-Djava.library.path=C:\\Users\\%s\\.f1oatingMineCraft\\versions\\natives", pcName));
			command.add("-Xmx4G");
			command.add("-Xms2G");
			command.add("-Dminecraft.launcher.brand=f1oatingMineCraft");
			command.add("-Dminecraft.launcher.version=0.1");
			command.add("-cp");
			command.add(cp);
			command.add("net.minecraft.launchwrapper.Launch");
			command.add(userName);
			command.add("--gameDir");
			command.add(gameDir);
			command.add("--assetsDir");
			command.add(assetsDir);
			
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			processBuilder.inheritIO();
			Process process = processBuilder.start();
			process.waitFor();

		}
}
