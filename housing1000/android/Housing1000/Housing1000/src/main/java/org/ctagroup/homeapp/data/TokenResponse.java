package org.ctagroup.homeapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author David Horton
 */
public class TokenResponse {

    private Date dateIssuedAsDate;

    private Date dateExpiresAsDate;

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("token_type")
    private String tokenType;

    @Expose
    @SerializedName("expires_in")
    private long expiresIn;

    @Expose
    @SerializedName(".issued")
    private String dateIssued;

    @Expose
    @SerializedName(".expires")
    private String dateExpires;


    @Override
    public String toString() {
        return "Access token: " + accessToken.substring(0, 30) + "..., Token type: " + tokenType + ", Expires in: " + expiresIn + ", Date issued: " + dateIssued + ", Date expires: " + dateExpires;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public String getDateExpires() {
        return dateExpires;
    }

    public Date getDateIssuedAsDate() {
        return dateIssuedAsDate;
    }

    public void setDateIssuedAsDate(Date dateIssuedAsDate) {
        this.dateIssuedAsDate = dateIssuedAsDate;
    }

    public Date getDateExpiresAsDate() {
        return dateExpiresAsDate;
    }

    public void setDateExpiresAsDate(Date dateExpiresAsDate) {
        this.dateExpiresAsDate = dateExpiresAsDate;
    }
}
