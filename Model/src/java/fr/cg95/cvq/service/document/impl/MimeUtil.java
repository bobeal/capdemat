package fr.cg95.cvq.service.document.impl;

import eu.medsea.mimeutil.MimeUtil2;

public class MimeUtil extends MimeUtil2 {

    public MimeUtil() {
        super();
        registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        registerMimeDetector("eu.medsea.mimeutil.detector.OpendesktopMimeDetector");
    }

    @Override
    protected void finalize()
        throws Throwable {
        unregisterMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        unregisterMimeDetector("eu.medsea.mimeutil.detector.OpendesktopMimeDetector");
    }
}
