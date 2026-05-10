package com.nt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ActorVO {

	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private String address;

	@NonNull
	private String category;

	@NonNull
	private Float fee;

}
