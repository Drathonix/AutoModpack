package pl.skidam.automodpack.client.modpack;

import pl.skidam.automodpack.utils.UnZipper;

import java.io.File;
import java.io.IOException;

import static pl.skidam.automodpack.AutoModpackMain.*;

public class UnZip {

    public UnZip(File out, String ModpackUpdated) {

        // Repeat this function every restart if modpack is up-to-date
        if (out.exists()) {

            // Start unzip
            LOGGER.info("Unzipping!");
            try {
                new UnZipper(out, new File("./"), "");
            } catch (IOException e) {
                LOGGER.error("Error while unzipping!\n" + e);
                e.printStackTrace();
            }
            LOGGER.info("Successfully unzipped!");

            // delete old mods
            new DeleteMods(false, ModpackUpdated);
        }
    }
}

