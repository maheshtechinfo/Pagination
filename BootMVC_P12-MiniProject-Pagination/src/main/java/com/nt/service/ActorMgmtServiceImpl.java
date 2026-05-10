package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.exception.ActorNotFoundException;
import com.nt.repository.IActorRepository;
import com.nt.vo.ActorVO;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public List<ActorVO> showAllActors() {
		// use repo
		List<ActorEntity> listEntities = actorRepo.findAll();
		// convert listEntities to listVO
		List<ActorVO> listVO = new ArrayList<>();
		listEntities.forEach(entity -> {
			ActorVO vo = new ActorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}

	@Override
	public String registerActor(ActorVO vo) {
		// convert VO class object to Entity class object
		ActorEntity entity = new ActorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("os.name"));
		// use repo
		int idVal = actorRepo.save(entity).getId();
		return "Actor obj is saved with the id value: " + idVal;
	}

	@Override
	public ActorVO showActorById(int id) {
		// Load the object
		ActorEntity entity = actorRepo.findById(id).orElseThrow(() -> new ActorNotFoundException("Invalid Id"));
		// convert entity class object to VO class object
		ActorVO vo = new ActorVO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}

	@Override
	public String updateActor(ActorVO vo) {
		// Load Actor Object
		ActorEntity entity = actorRepo.findById(vo.getId()).orElseThrow(() -> new ActorNotFoundException("Invalid Id"));
		// convert VO class object data to Entity Object
		BeanUtils.copyProperties(vo, entity);
		// update the object
		actorRepo.save(entity);
		return vo.getId() + " Actor details are updated";
	}

	@Override
	public String deleteActor(int id) {
		ActorEntity entity = actorRepo.findById(id).orElseThrow(() -> new ActorNotFoundException("Invalid Id"));
		// delete the object
		actorRepo.delete(entity);
		return id + " Actor is  deleted";
	}

	@Override
	public Page<ActorVO> showAllActorsByPagination(Pageable pageable) {
		// use repo
		Page<ActorEntity> pageEntity = actorRepo.findAll(pageable);
		// convert List of Entities to List of VO
		List<ActorVO> listVO = new ArrayList<ActorVO>();
		List<ActorEntity> listEntity = pageEntity.getContent();
		listEntity.forEach(entity -> {
			ActorVO vo = new ActorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		// convert Page<ACtorEntity> obj to Page<ActorVO> object
		Page<ActorVO> pageVO = new PageImpl<ActorVO>(listVO, pageable, actorRepo.count());
		return pageVO;

	}

}
