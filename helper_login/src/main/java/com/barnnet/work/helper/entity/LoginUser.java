package com.barnnet.work.helper.entity;

import lombok.Data;

@Data
public class LoginUser {
  private long id;
  private String userName;
  private String userPassword;
  private String email;
  private String phone;
  private String salt;
  private String ipDress;
}
