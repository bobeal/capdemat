package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;

import fr.cg95.cvq.business.Historizable;
import fr.cg95.cvq.service.users.IsFrenchRIB;
import fr.cg95.cvq.xml.common.FrenchRIBType;

/**
 * @hibernate.class
 *  table="french_r_i_b"
 *  lazy="false"
 *
 * @author jsb@zenexity.fr
 */
@IsFrenchRIB
public class FrenchRIB implements Historizable, Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    public static FrenchRIB xmlToModel(FrenchRIBType frenchRIBType) {
        if (frenchRIBType == null) return null;
        FrenchRIB frenchRIB = new FrenchRIB();
        frenchRIB.setAccountKey(frenchRIBType.getAccountKey());
        frenchRIB.setAccountNumber(frenchRIBType.getAccountNumber());
        frenchRIB.setBankCode(frenchRIBType.getBankCode());
        frenchRIB.setCounterCode(frenchRIBType.getCounterCode());
        frenchRIB.setId(frenchRIBType.getId());
        return frenchRIB;
    }

    public static FrenchRIBType modelToXml(FrenchRIB frenchRIB) {
        if (frenchRIB == null) return null;
        FrenchRIBType frenchRIBType = FrenchRIBType.Factory.newInstance();
        frenchRIBType.setAccountKey(frenchRIB.getAccountKey());
        frenchRIBType.setAccountNumber(frenchRIB.getAccountNumber());
        frenchRIBType.setBankCode(frenchRIB.getBankCode());
        frenchRIBType.setCounterCode(frenchRIB.getCounterCode());
        return frenchRIBType;
    }

    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 99999)
    private Integer bankCode;

    @NotNull
    @Min(value = 1)
    @Max(value = 99999)
    private Integer counterCode;

    @NotNull
    @MatchPattern(pattern = {"^[a-zA-Z0-9]{1,11}$"})
    private String accountNumber;

    @NotNull
    @Min(value = 1)
    @Max(value = 97)
    private Integer accountKey;

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="bank_code"
     *  not-null="true"
     */
    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @hibernate.property
     *  column="counter_code"
     *  not-null="true"
     */
    public Integer getCounterCode() {
        return counterCode;
    }

    public void setCounterCode(Integer counterCode) {
        this.counterCode = counterCode;
    }

    /**
     * @hibernate.property
     *  column="account_number"
     *  length="11"
     *  not-null="true"
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @hibernate.property
     *  column="account_key"
     *  not-null="true"
     */
    public Integer getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(Integer accountKey) {
        this.accountKey = accountKey;
    }

    @Override
    public String toString() {
        return StringUtils.leftPad(bankCode.toString(), 5, '0')
            + StringUtils.leftPad(counterCode.toString(), 5, '0')
            + StringUtils.leftPad(accountNumber, 11, '0')
            + StringUtils.leftPad(accountKey.toString(), 2, '0');
    }
}
