package fr.cg95.cvq.service.social;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.social.DhrAssetKindType;
import fr.cg95.cvq.business.social.DhrAssetTypeType;
import fr.cg95.cvq.business.social.DhrNotRealAsset;
import fr.cg95.cvq.business.social.DhrRealAsset;
import fr.cg95.cvq.business.social.DhrRequestKindType;
import fr.cg95.cvq.business.social.DhrRequesterHasSpouse;
import fr.cg95.cvq.business.social.DomesticHelpRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.HomeFolder;

public class DomesticHelpRequestFeeder {

    public static void feed(DomesticHelpRequest request) {

        // Set<DhrPreviousDwelling> previousDwellingSet = new
        // HashSet<DhrPreviousDwelling>();
        // for (int i = 0; i < 3; i++) {
        // DhrPreviousDwelling previousDwelling = new DhrPreviousDwelling();
        // previousDwelling.setPreviousDwellingAddress(
        // new Address("103", "bd McDonald Previous Dwelling","75019",
        // "PARIS n=" + i));
        // previousDwelling.setPreviousDwellingArrivalDate(new Date());
        // previousDwelling.setPreviousDwellingDepartureDate(new Date());
        //
        // previousDwellingSet.add(previousDwelling);
        // }
        // request.setPreviousDwelling(previousDwellingSet);

        request.setRequesterHasSpouse(DhrRequesterHasSpouse.FALSE);
        System.out.println("***************************************** : "
                + request.getRequesterHasSpouse());

        Set<DhrRealAsset> realAssetSet = new HashSet<DhrRealAsset>();
        for (int i = 0; i < 3; i++) {
            DhrRealAsset realAsset = new DhrRealAsset();
//            realAsset.setRealAssetAddress(new Address("103", " bd McDonald Real Asset", "75019",
//                    "PARIS n=" + i));
//            realAsset.setRealAssetNetFloorArea(new BigInteger("100"));
            realAsset.setRealAssetValue(new BigInteger("100"));

            realAssetSet.add(realAsset);
        }
        request.setRealAssets(realAssetSet);

        Set<DhrNotRealAsset> donationSet = new HashSet<DhrNotRealAsset>();
        for (int i = 0; i < 3; i++) {
            DhrNotRealAsset donation = new DhrNotRealAsset();
            donation.setAssetType(DhrAssetTypeType.GIFT);
            donation.setAssetKind(DhrAssetKindType.REAL_ESTATE);
//            donation
//                    .setAssetAddress(new Address("103", "bd McDonald  ASSET" + i, "75019", "PARIS"));
            donation.setAssetBeneficiaryName("ASSET BENEFICIARY NAME" + i);
            donation.setAssetBeneficiaryFirstName("ASSET BENEFICIARY FIRSTNAME" + i);
//            donation.setAssetBeneficiaryAddress(new Address("103", "bd McDonald ASSET BENEFICIARY"
//                    + i, "75019", "PARIS"));
            donation.setAssetValue(new BigInteger("1000"));
            donation.setAssetDate(new Date());
            donation.setAssetNotaryName("ASSET NOTARY NAME" + i);
//            donation.setAssetNotaryAddress(new Address("103", "bd McDonald Donation ASSET" + i,
//                    "75019", "PARIS"));
            donation.setAssetValue(new BigInteger("1000"));

            donationSet.add(donation);
        }
        request.setNotRealAssets(donationSet);
    }

    public static void setSubject(DomesticHelpRequest request, HomeFolder homeFolder) {

        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}