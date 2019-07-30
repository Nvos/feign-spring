package com.czort.app.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	@Override
	public User save(User user) {
		UserEntity savedEntity = userRepository.save(userMapper.fromDto(user));
		return userMapper.fromEntity(savedEntity);
	}

	@Override
	public User update(User user) {
		UserEntity entity = userRepository.getOne(user.getId());
		userMapper.toEntity(user, entity);

		return userMapper.fromEntity(entity);
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).map(userMapper::fromEntity).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll().stream().map(userMapper::fromEntity).map(it -> it).map(it -> it).map(it -> it)
				.collect(Collectors.toList());
	}

}
