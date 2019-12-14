package com.codingdojo.javaspring.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javaspring.lookify.models.Lookify;
import com.codingdojo.javaspring.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	////add lookify repository\\\
	@Autowired
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	///return all songs\\\
	public List<Lookify> allSongs(){
		return lookifyRepository.findAll();
	}
	///create a song\\\
	public Lookify createSong(Lookify slap) {
		return lookifyRepository.save(slap);
	}
	///retrieve a song\\\
	public Lookify findSong(long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	////update a song\\\
	public Lookify updateSong(Lookify slap) {
		return lookifyRepository.save(slap);
	}
	///delete a song\\\
	public void deleteSong(long id) {
		this.lookifyRepository.deleteById(id);
	}
	//top 10 songs\\
	public List<Lookify> getTopTen(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	///find by artist\\\
	public List<Lookify> getArtistSongs(String artist){
		return lookifyRepository.findByArtist(artist);
	}
}
