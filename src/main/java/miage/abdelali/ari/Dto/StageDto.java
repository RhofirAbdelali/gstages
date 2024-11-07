package miage.abdelali.ari.Dto;

import java.util.List;

public class StageDto {
    
    private Long id;
    private String name;
    private String description;
    private List<StudentDto> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
}