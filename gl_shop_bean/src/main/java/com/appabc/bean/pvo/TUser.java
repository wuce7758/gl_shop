package com.appabc.bean.pvo;

import java.util.Date;

import com.appabc.bean.enums.AuthRecordInfo.AuthRecordStatus;
import com.appabc.bean.enums.CompanyInfo.CompanyBailStatus;
import com.appabc.bean.enums.CompanyInfo.CompanyType;
import com.appabc.bean.enums.SystemInfo.ServerEnvironmentEnum;
import com.appabc.bean.enums.UserInfo.ClientTypeEnum;
import com.appabc.bean.enums.UserInfo.UserStatus;
import com.appabc.common.base.bean.BaseBean;

public class TUser extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4620192754409500892L;

    /**
     * 企业编号
     */
    private String cid;
    
    private String cname; // 企业名称
    
    private CompanyType ctype;//企业类型（区分企业、船舶、个人）

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像ID
     */
    private String logo;

    /**
     * 用户状态（正常、限制、禁用）
     */
    private UserStatus status;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 修改时间
     */
    private Date updatedate;
    
    /**
     * 客户端ID
     */
    private String clientid;
    
    /**
     * 客户端类型
     */
    private ClientTypeEnum clienttype;
    
    /**
     * 客户端使用的版本号
     */
    private String version;
    
    private String userToken;
    
    private Integer effTimeLength; // userToken 有效时长，单位：秒
    
    private int contractTotal; // 合同数
    private int orderfindTotal; // 询单数
    private double deposit; // 货款余额
    private double guaranty; // 保证金余额
    private ServerEnvironmentEnum serverEnvironment; // 服务器环境:开发:0、测试:1、正式:2
    private int isAuthRemind; // 是否认证提醒,0 no ,1 yes;
    
    public int getIsAuthRemind() {
		return isAuthRemind;
	}

	public void setIsAuthRemind(int isAuthRemind) {
		this.isAuthRemind = isAuthRemind;
	}

	/**
     * 保证金缴纳状态（是否缴纳足额）
     */
    private CompanyBailStatus bailstatus;
    /**
     * 认证状态(是否认证)
     */
    private AuthRecordStatus authstatus;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Integer getEffTimeLength() {
		return effTimeLength;
	}

	public void setEffTimeLength(Integer effTimeLength) {
		this.effTimeLength = effTimeLength;
	}

	public int getContractTotal() {
		return contractTotal;
	}

	public void setContractTotal(int contractTotal) {
		this.contractTotal = contractTotal;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public ClientTypeEnum getClienttype() {
		return clienttype;
	}

	public void setClienttype(ClientTypeEnum clienttype) {
		this.clienttype = clienttype;
	}

	public CompanyType getCtype() {
		return ctype;
	}

	public void setCtype(CompanyType ctype) {
		this.ctype = ctype;
	}

	public CompanyBailStatus getBailstatus() {
		return bailstatus;
	}

	public void setBailstatus(CompanyBailStatus bailstatus) {
		this.bailstatus = bailstatus;
	}

	public int getOrderfindTotal() {
		return orderfindTotal;
	}

	public void setOrderfindTotal(int orderfindTotal) {
		this.orderfindTotal = orderfindTotal;
	}

	public AuthRecordStatus getAuthstatus() {
		return authstatus;
	}

	public void setAuthstatus(AuthRecordStatus authstatus) {
		this.authstatus = authstatus;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getGuaranty() {
		return guaranty;
	}

	public void setGuaranty(double guaranty) {
		this.guaranty = guaranty;
	}

	public ServerEnvironmentEnum getServerEnvironment() {
		return serverEnvironment;
	}

	public void setServerEnvironment(ServerEnvironmentEnum serverEnvironment) {
		this.serverEnvironment = serverEnvironment;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    
}