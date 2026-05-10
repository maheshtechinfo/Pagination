package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.vo.ActorVO;

public interface IActorMgmtService {
	public List<ActorVO> showAllActors();

	public String registerActor(ActorVO vo);

	public ActorVO showActorById(int id);

	public String updateActor(ActorVO vo);

	public String deleteActor(int id);

	public Page<ActorVO> showAllActorsByPagination(Pageable pageable);

}
