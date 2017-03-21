package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xiyou.entity.File;

public interface FileDao extends JpaRepository<File, String> {
	public Page<File> findAll(Pageable pageable);

	public File findById(String id);

	@Query("select count(*) from File f where f.filename = ?")
	public int findHaved(String fileName);
	
	public Page<File> findByFilenameContaining(String filename, Pageable pageable);

	public Page<File> findByFiletypeContaining(String filetype, Pageable pageable);

	public Page<File> findByUploaderContaining(String uploader, Pageable pageable);

	public List<File> findByFilenameContaining(String filename);
}
