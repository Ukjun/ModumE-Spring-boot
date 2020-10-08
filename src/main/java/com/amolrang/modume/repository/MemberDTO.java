package com.amolrang.modume.repository;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Builder
@ToString
public class MemberDTO {
    private String id;
    private String user_email;
    private String user_name;
    private String user_status;
    private String auth_site;
    private String user_password;
    private String user_role;
}