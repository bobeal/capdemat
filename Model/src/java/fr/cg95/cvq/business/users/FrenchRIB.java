package fr.cg95.cvq.business.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;

import fr.cg95.cvq.service.users.IsFrenchRIB;
import fr.cg95.cvq.xml.common.FrenchRIBType;

@Entity
@Table(name="french_r_i_b")
@IsFrenchRIB
public class FrenchRIB implements Serializable, Cloneable {

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

    @Override
    public FrenchRIB clone() {
        FrenchRIB result = new FrenchRIB();
        result.setAccountKey(getAccountKey());
        result.setAccountNumber(getAccountNumber());
        result.setBankCode(getBankCode());
        result.setCounterCode(getCounterCode());
        return result;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "bankCode")
    @Min(value = 1, message = "bankCode")
    @Max(value = 99999, message = "bankCode")
    @Column(name="bank_code",nullable=false)
    private Integer bankCode;

    @NotNull(message = "counterCode")
    @Min(value = 0, message = "counterCode")
    @Max(value = 99999, message = "counterCode")
    @Column(name="counter_code",nullable=false)
    private Integer counterCode;

    @NotNull(message = "accountNumber")
    @MatchPattern(pattern = {"^[a-zA-Z0-9]{1,11}$"}, message = "accountNumber")
    @Column(name="account_number",length=11, nullable=false)
    private String accountNumber;

    @NotNull(message = "accountKey")
    @Min(value = 1, message = "accountKey")
    @Max(value = 97, message = "accountKey")
    @Column(name="account_key",nullable=false)
    private Integer accountKey;

    public String format(String separator) {
        return StringUtils.join(new String[]{
            bankCode == null ? "00000" : StringUtils.leftPad(bankCode.toString(), 5, '0'),
            counterCode == null ? "00000" : StringUtils.leftPad(counterCode.toString(), 5, '0'),
            accountNumber,
            accountKey == null ? "00" : StringUtils.leftPad(accountKey.toString(), 2, '0')
        }, separator);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getCounterCode() {
        return counterCode;
    }

    public void setCounterCode(Integer counterCode) {
        this.counterCode = counterCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = StringUtils.leftPad(accountNumber, 11, '0').toUpperCase();
    }

    public Integer getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(Integer accountKey) {
        this.accountKey = accountKey;
    }
}
