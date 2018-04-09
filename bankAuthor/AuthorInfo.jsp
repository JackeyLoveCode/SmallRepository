<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="egov" uri="http://www.some.egov.jstl.fn"%>
<table width="1000" height="300" border="1" bordercolor="blue">
  <tr>
	<td>核准件编号</td><td><span id="a_no">${author.a_no }</span></td><td>登记日期</td><td><span id="regdate">${author.regdate }</span></td>
  </tr>
  <tr>
	<td>限额币种</td><td><span id="reg_curr">${egov:getStringByCode2("cur.",author.reg_curr ) }</span></td><td>账户限额</td><td><span id="reg_capital">${author.reg_capital }</span></td>
  </tr>
  <tr>
  	<td>联系人</td><td><span id="contact">${author.contact }</span></td><td>联系电话</td><td><span id="contact_pho_num">${author.contact_pho_num }</span></td>
  </tr>
</table>

