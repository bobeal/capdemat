package fr.cg95.cvq.wizard.manager;

import java.io.FileWriter;

public class ManagerTest {

	public ManagerTest() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String xmlFile = args[0];
			String outFile = args[1];
			
			FileWriter out = new FileWriter(outFile);
			
			ManagerWizardPlugin plugin = new ManagerWizardPlugin();
			
			plugin.setFiles(xmlFile);
			
			plugin.init(null, null);
			
			ManagerWizard manager = plugin.getManager("cartevaloise.valdoise.fr","request");
			
			if (manager != null) {
				manager.testPage(out);
				out.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
