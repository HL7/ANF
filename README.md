
# Analysis Normal Form (ANF), Release 1

(approved during the September 2019 ballot cycle, published: January 2020)


# Official Release
The official release is available in the **document-storage** folder:

> https://github.com/HL7/ANF/blob/master/document-storage/HL7_CIMI_LM_ANF_R1_INFORM_2020JAN.pdf

## **Developer Guidance**

>All Git functionality in this guide is based on the **Fork Git** client (https://git-fork.com/). 

**Prerequisite:**
You must have java and maven installed. Fork and Oxygen are recommended. You can find installation instruction in the “Installation Guide for DocBook development” document. After installing, please do not update your Java version from Java 8. This could potentially cause problems with the PDF build.** 

### Steps to edit, add, and update content for the ANF specification:

**1.	If it is your first time working with the HL7 ANF repository you must start by cloning the repository.** Otherwise, you must pull to get the most recent version of the repository.**

To clone the repository, follow the following steps:
1.	Open Fork
2.	Select File -> Clone…
3.	Place “https://github.com/HL7/ANF.git” in the “Repository URL” field.
4.	Select where you would like your local repository to live in the “Parent Folder” field – if you have already set up a parent folder for another repository (i.e C:\code), please consider using the same folder for consistency. 
5.	In the name field, enter the name for your local repository (i.e. how the repository will appear in your file explorer) using a name like “ANF Specifcation”.
6.	Click “Clone”

If you already have a local version of the repository, follow the steps below:
1.	Open Fork
2.	The repository might already be open in the Fork GUI. If so, you will see the name of the repository (from step e above) in a tab on the top portion of the screen. Click on the tab and the skip to step e below. If the repository is not already open, proceed to step c.
3.	Select File -> Open Repository…
4.	Navigate to the directory that you cloned the repository and click “Select folder”
5.	Once the repository is open Fork, click the “Pull” button in the upper left (the arrow that is pointing downward      )

**2.	Locate the appropriate XML file that you would like to make your changes in.** Each XML file corresponds to a different section of the repository. The “root” xml file is called “hl7-anf-ballot-root.xml” and is in the “ballot-root” module. Within this file, you will find a reference to other XML files for each section of the ANF document.

**3.	Make any changes that you would like, by adding, editing, or deleting existing content in the XML file.** This can be done by editing in Oxygen’s Author (WYSIWYG) view or Text (raw XML) view. Save your work.

**4.	Perform a maven clean install.** There are directions in the “Installation Guide for DocBook Development” for configuring this button within Oxygen. This command will trigger the document build. This button is located on the top panel of Oxygen and has a green play button icon associated with it.

In Oxygen you will see a build log. Once the build is complete, you will either see “Build Success” or “Build Failure.” If the build succeeded, you may proceed to step 5. Otherwise DO NOT PROCEED UNTIL YOU HAVE RESOLVED THE BUILD ERROR.

**5.	Pull immediately before committing.** To pull, make sure you still have the ANF repository open in Fork and click the “Pull” button in the upper left. Fork may notify you that you have uncommitted changes. If so, select “Stash and Reapply.” 

Resolve any merge conflicts that may occur and seek help if needed. Reach out to Kyle Maulden at kmaulden@deloitte.com or Ryan Bradley at rbradley@deloitte.com for help.
 
**6.	Commit your changes, with a meaningful commit message.** Do this, by clicking on the “Changes” tab on the left hand side of Fork. Once you click on changes you will see two panels in the screen, one names “Unstaged Files” and the other names “Staged Files.” Move all files that you wish to commit from “Unstaged” to “Staged” by clicking on each individual file and clicking “Stage.”

Once all desired files have been staged, enter a commit subject and description on the bottom portion of the screen that describes the work you have done and then press the “Commit” button in the bottom right.

**7.	Push your changes by clicking the “Push” button in the upper left.**

Verify that you changes have been pushed successfully by clicking on “All Commits” on the left hand part of the screen. You should see your commit description and name on the top row with both the red “master” tag and the green “origin/master” tag. This indicates that your local version of the repository is in sync with what is on GitHub and that all changes have been made public.

### Steps to build the PDF output from the ANF repository:

1.	Start by obtaining a local copy of the most recent version of the repository. This process is described in step 1 above.
2.	Perform a “mvn clean install” as described in step 4 above to build the PDF document.
3.	Go to the ANF root repository and navigate to *ballot-root/target folder*.
4. Unzip the “ballot-root-0.13-SNAPSHOT-pdf.zip”  
5. Navigate to org.hl7 ->  ballot-root
6.	Open the “hl7-anf-ballot-root.pdf” document.    

