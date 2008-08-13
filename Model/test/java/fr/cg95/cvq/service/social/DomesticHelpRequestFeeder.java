package fr.cg95.cvq.service.social;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.social.DhrDonation;
import fr.cg95.cvq.business.social.DhrDonationAssetType;
import fr.cg95.cvq.business.social.DhrPersonalEstateAndSaving;
import fr.cg95.cvq.business.social.DhrPreviousDwelling;
import fr.cg95.cvq.business.social.DhrRealAsset;
import fr.cg95.cvq.business.social.DomesticHelpRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.HomeFolder;

public class DomesticHelpRequestFeeder {

    public static void feed(DomesticHelpRequest request) {
        
        Set<DhrPreviousDwelling> previousDwellingSet = new HashSet<DhrPreviousDwelling>();
        for (int i = 0; i < 3; i++) {
            DhrPreviousDwelling previousDwelling = new DhrPreviousDwelling();
            previousDwelling.setPreviousDwellingAddress(
                    new Address("103", "bd McDonald Previous Dwelling","75019", "PARIS n=" + i));
            previousDwelling.setPreviousDwellingArrivalDate(new Date());
            previousDwelling.setPreviousDwellingDepartureDate(new Date());

            previousDwellingSet.add(previousDwelling);
        }
        request.setPreviousDwellings(previousDwellingSet);
        
        Set<DhrRealAsset> realAssetSet = new HashSet<DhrRealAsset>();
        for (int i = 0; i < 3; i++) {
            DhrRealAsset realAsset = new DhrRealAsset();
            realAsset.setRealAssetAddress(
                    new Address("103", " bd McDonald Real Asset","75019", "PARIS n=" + i));
            realAsset.setRealAssetCadastre("REAL_ASSET_CADASTRE n=" + i);
            realAsset.setRealAssetNetFloorArea(new BigInteger("100"));
            realAsset.setRealAssetValue(new BigInteger("100"));
            
            realAssetSet.add(realAsset);
        }
        request.setRealAssets(realAssetSet);
        
        Set<DhrPersonalEstateAndSaving> savingSet = new HashSet<DhrPersonalEstateAndSaving>();
        for (int i = 0; i < 3; i++) {
            DhrPersonalEstateAndSaving saving = new DhrPersonalEstateAndSaving();
            saving.setPaybookAmount(new BigInteger("1000"+i ) );
            saving.setPaybookNumber("0001");
            
            savingSet.add(saving);
        }
        request.setSavings(savingSet);
        
        Set<DhrDonation> donationSet = new HashSet<DhrDonation>();
        for (int i = 0; i < 3; i++) {
            DhrDonation donation = new DhrDonation();
            donation.setDonationAsset(DhrDonationAssetType.IMMOBILIER);
            donation.setDonationAssetPlace("DONNATION -> PARISn=" + i);
            donation.setDonationBeneficiaryName("DONATION BENEFICIARY NAME");
            donation.setDonationBeneficiaryFirstName("DONATION BENEFICIARY FIRSTNAME");
            donation.setDonationDate(new Date());
            donation.setDonationNotaryName("DONATION NOTARY NAME");
            donation.setDonationNotaryFirstName("DONATION NOTARY FIRTNAME");
            donation.setDonationNotaryAddress(
                    new Address("103","bd McDonald Donation Notary","75019", "PARIS"));
            donation.setDonationValue(new BigInteger("1000"));
            
            donationSet.add(donation);
        }
        request.setDonations(donationSet);
    }
    
    public static void setSubject(DomesticHelpRequest request,
            HomeFolder homeFolder) {
        
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
