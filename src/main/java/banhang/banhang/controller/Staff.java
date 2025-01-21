package banhang.banhang.controller;

import java.util.Date;

import lombok.Data;

@Data
public class Staff {
  String uname;
  String pass;
  String photo;
  Date birthday;
}
