package com.box.little.littlebox;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class POJO {

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;

    /**
     *
     * @return
     * The user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The from
     */
    public String getFrom() {
        return from;
    }

    /**
     *
     * @param from
     * The from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     *
     * @return
     * The to
     */
    public String getTo() {
        return to;
    }

    /**
     *
     * @param to
     * The to
     */
    public void setTo(String to) {
        this.to = to;
    }

}