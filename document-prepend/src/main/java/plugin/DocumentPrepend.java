package plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.FileNotFoundException;
import java.io.IOException;


@Mojo( name = "prependdocument")
public class DocumentPrepend extends AbstractMojo {

    @Parameter(property = "prependdocument.sourcePath")
    private String sourcePath;

    @Parameter(property = "prependdocument.coverPath")
    private String coverPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        try {
            PDFMergerUtility ut = new PDFMergerUtility();
            ut.addSource(this.coverPath);
            ut.addSource(this.sourcePath);
            ut.setDestinationFileName(this.sourcePath);

            ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
