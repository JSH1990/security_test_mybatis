package com.fastcampus.ch6.service;

import com.fastcampus.ch6.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {

	public ArrayList<UserDto> teamSelect(UserDto dto);
	public ArrayList<UserDto> teamLeaderSelect(UserDto dto);
	public ArrayList<UserDto> teamMemberListSelect(UserDto dto);
	public ArrayList<UserDto> companyListSelect();
	public void teamInsert(UserDto dto);
	public ArrayList<UserDto> teamMemberSelect(UserDto dto);
	public ArrayList<UserDto> teamlistSelect(UserDto dto);
	public UserDto userInfoSelect(UserDto dto);
	public void userInfoUpdate(UserDto dto);
	public void userAuthLevelUpdate(UserDto dto);
	public ArrayList<UserDto> userCompanyListSelect(UserDto dto);
	public ArrayList<UserDto> userTeamListSelect(UserDto dto);
	public int userIdSelect(UserDto dto);
	public void userInsert(UserDto dto);
	public void userTeamDelete(UserDto dto);
	public ArrayList<UserDto> userCompanySelect(UserDto dto);
	public ArrayList<UserDto> userTeamSelect(UserDto dto);
	public void teamUserInsert(UserDto dto);
	public void userCompanyUpdate(UserDto dto);
	public void userMappingDelete(UserDto dto);
	public ArrayList<UserDto> authTeamListSelect(UserDto dto);
	public ArrayList<UserDto> authTeamCheckListSelect(UserDto dto);
	public ArrayList<UserDto> teamMemberSelected(UserDto dto);
	public ArrayList<UserDto> teamlistSelected(UserDto dto);
	public int teamUserCheck(UserDto dto);
	public void authViewRoleInsert(UserDto dto);
	public void userInfoModify(UserDto dto);
	public void teamInfoDelete(UserDto dto);
	public void teamUpdate(UserDto dto);
	public int countMember(UserDto dto);
	public int userTeamCheck(UserDto dto);
	public ArrayList<UserDto> getMemtable(UserDto dto);
	public void goodBeyM(int mseq);
	public void welComeM(int mseq);
	public void teamChange(UserDto dto);
	public UserDto getMemtableDetail(int userSeq);
	public void userMemberModifyUpdate(UserDto dto);	
	public void userteamChange(UserDto dto);
}
