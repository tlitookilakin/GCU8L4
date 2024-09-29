package co.grandcircus.jobtracker;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPosting, Long> {
	public List<JobPosting> findByCompanyName(String name);
}

/*
--INSERT INTO company SELECT DISTINCT company, NULL FROM job_posting;
--UPDATE job_posting SET company_id=(SELECT id FROM company WHERE [name] = job_posting.company)
--ALTER TABLE job_posting DROP COLUMN company;
 */