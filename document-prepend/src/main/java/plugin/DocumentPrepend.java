package plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitWidthDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

import java.io.File;
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
    public void execute() {

        try {
            mergeDocuments(this.sourcePath);
            mergeDocuments(this.sourceXEPPath);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mergeDocuments(String path) throws IOException {
        PDFMergerUtility ut = new PDFMergerUtility();
        ut.addSource(this.coverPath);
        ut.addSource(path);
        ut.setDestinationFileName(path);

        ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        PDDocument doc = PDDocument.load(new File(path));
        PDDocumentOutline bookmarks = doc.getDocumentCatalog().getDocumentOutline();
        PDOutlineItem item = bookmarks.getFirstChild();
        item.setTitle("ANF Informative Ballot");
        PDPageDestination dest = new PDPageFitWidthDestination();
        dest.setPage(doc.getPage(0));
        item.setDestination(dest);

        PDActionGoTo action = new PDActionGoTo();
        action.setDestination(dest);

        doc.getDocumentCatalog().setOpenAction(action);

        doc.save(new File(path));
        doc.close();
    }
}
