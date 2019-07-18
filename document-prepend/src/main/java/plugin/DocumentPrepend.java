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

    @Parameter(property = "prependdocument.sourceXEPPath")
    private String sourceXEPPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        try {
            PDFMergerUtility ut = new PDFMergerUtility();
            ut.addSource(this.coverPath);
            ut.addSource(this.sourcePath);
            ut.setDestinationFileName(this.sourcePath);

            ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

            PDFMergerUtility ut1 = new PDFMergerUtility();
            ut1.addSource(this.coverPath);
            ut1.addSource(this.sourceXEPPath);
            ut1.setDestinationFileName(this.sourceXEPPath);

            ut1.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
