package com.amolrang.modume.repository;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberModel {
	private String id;
    private String user_email;
    private String user_name;
    private String user_status;
    private String auth_site;
    private String user_password;
    private String user_role;
}
