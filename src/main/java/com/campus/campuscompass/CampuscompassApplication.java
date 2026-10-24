package com.campus.campuscompass;

import com.campus.campuscompass.model.Document;
import com.campus.campuscompass.repository.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampuscompassApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampuscompassApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(DocumentRepository repository) {
		return (args) -> {
			String[][] campusDatabase = {
					// ==========================================
					// 1. STUDY MATERIALS - DEPARTMENT & SEMESTER WISE
					// ==========================================
					{"CSE - Semester 1 Subjects & Books", "Subjects: Engineering Mathematics I, Engineering Physics, Engineering Chemistry, Python Programming. Books: Higher Engineering Mathematics by B.S. Grewal, Python by John Zelle.", "Study materials"},
					{"CSE - Semester 2 Subjects & Books", "Subjects: Engineering Mathematics II, Object Oriented Programming, Basic Electrical, Engineering Chemistry II. Books: Herbert Schildt (Java).", "Study materials"},
					{"CSE - Semester 3 Subjects & Books", "Subjects: Discrete Mathematics, Data Structures, Digital Principles, DBMS, Java Programming. Books: Mark Allen Weiss, Silberschatz.", "Study materials"},
					{"CSE - Semester 4 Subjects & Books", "Subjects: Algorithms, Operating Systems, Computer Networks, Theory of Computation, Computer Organization. Books: Cormen, Tanenbaum.", "Study materials"},
					{"CSE - Semester 5 Subjects & Books", "Subjects: Artificial Intelligence, Software Engineering, Compiler Design, OOAD. Books: Stuart Russell, Roger Pressman.", "Study materials"},
					{"CSE - Semester 6 Subjects & Books", "Subjects: Machine Learning, Distributed Systems, Cryptography and Network Security. Books: Tom Mitchell, William Stallings.", "Study materials"},
					{"CSE - Semester 7 & 8 Subjects & Books", "Subjects: Professional Electives, Cloud Computing, Major Project Work, and Internship Guidelines.", "Study materials"},

					{"IT - Semester 1 & 2 Subjects & Books", "Subjects: Python Programming, Engineering Mathematics, Object Oriented Programming, Physics, Engineering Graphics, Tamil and Technology.", "Study materials"},
					{"IT - Semester 3 & 4 Subjects & Books", "Subjects: Data Structures, Database Management Systems, Java Programming, Design and Analysis of Algorithms, Operating Systems, Computer Networks.", "Study materials"},
					{"IT - Semester 5 & 6 Subjects & Books", "Subjects: Artificial Intelligence, Web Technology, Information Security, Machine Learning, Cloud Computing, Distributed Systems.", "Study materials"},

					{"ECE - Semester 1 to 4 Subjects & Books", "Subjects: Engineering Mathematics, Circuit Analysis, Electronic Devices, Signals and Systems, Microprocessors, Control Systems.", "Study materials"},
					{"ECE - Semester 5 to 8 Subjects & Books", "Subjects: Digital Signal Processing, VLSI Design, Wireless Communication, Antennas, Embedded Systems, Project Work.", "Study materials"},

					{"EEE - Semester 1 to 4 Subjects & Books", "Subjects: Circuit Theory, Electronic Devices, Electrical Machines I & II, Digital Logic Circuits, Power System Analysis.", "Study materials"},
					{"EEE - Semester 5 to 8 Subjects & Books", "Subjects: Power Electronics, Power System Operation, Microprocessors, Renewable Energy Systems, High Voltage Engineering.", "Study materials"},

					{"Printing - Semester 1 to 8 Subjects & Books", "Subjects: Graphics Communication, Printing Processes, Packaging Materials, Flexography and Gravure, Offset Printing, Sustainable Packaging, Print Management.", "Study materials"},

					{"Geoinformatics - Semester 1 to 8 Subjects & Books", "Subjects: Surveying, Geospatial Data Structures, Remote Sensing, Photogrammetry, Cartography and GIS, Microwave Remote Sensing, Spatial Analytics, Cloud-Based GIS.", "Study materials"},

					// ==========================================
					// 2. CAMPUS INFORMATION - HOSTELS (Boys & Girls)
					// ==========================================
					{"Girls Hostel - Roja Hostel", "Capacity: 150 rooms. Features 24/7 Wi-Fi, reading hall, indoor games room, and secure biometric entry.", "Campus information"},
					{"Girls Hostel - Mullai Hostel", "Capacity: 120 rooms. Dedicated block for second-year students with attached mess and solar water heaters.", "Campus information"},
					{"Girls Hostel - Thamarai Hostel", "Capacity: 200 rooms. Premium block featuring modern dining facility, gym, and study lounges.", "Campus information"},
					{"Girls Hostel - Malligai Hostel", "Capacity: 100 rooms. Peaceful environment with guest rooms and student welfare office inside.", "Campus information"},
					{"Boys Hostel - Sembaruthi Hostel", "Capacity: 180 rooms. Main boys hostel block equipped with recreation room, laundry services, and high-speed Wi-Fi.", "Campus information"},
					{"Boys Hostel - Chithira Hostel", "Capacity: 140 rooms. Second boys block near the sports complex with 24/7 security and mess facility.", "Campus information"},
					{"Boys Hostel - Alli Hostel", "Capacity: 160 rooms. Final year boys block with single-occupancy options and quiet study zones.", "Campus information"},
					{"Campus Infrastructure & Labs", "Central Library open 8 AM to 8 PM with 50,000+ books. Main Auditorium with 1,500 seating capacity. Advanced computing labs in Main Engineering Block.", "Campus information"},

					// ==========================================
					// 3. ANNOUNCEMENTS (Extended)
					// ==========================================
					{"End Semester Examination Time Table Released", "The official timetable for upcoming even-semester university examinations has been published on the portal. Check department notice boards for seating arrangements.", "Announcements"},
					{"Placement Training & Aptitude Classes", "Mandatory soft skills and coding training sessions for final and pre-final year students will begin this Wednesday at the main auditorium.", "Announcements"},
					{"Annual Tech Symposium 'CampusCompass 2026'", "Call for project abstracts, hackathons, and web design competition registrations are now open across all engineering departments.", "Announcements"},
					{"Internal Assessment Test-2 Schedule", "The second internal assessment tests will commence from next Monday. Portions have been shared by respective course instructors.", "Announcements"},
					{"Library Book Return Deadline Notice", "All students must return or renew borrowed library reference books before the end of the current month to avoid fines.", "Announcements"},
					{"Sports Meet Inter-Departmental Fixtures", "Annual athletic events and cricket/football tournament fixtures have been posted on the sports complex notice board.", "Announcements"},


					// ==========================================
					// 4. DOCUMENT RETRIEVAL (Extended)
					// ==========================================
					{"Bonafide Certificate Request Form", "Downloadable template and procedure to apply for course bonafide certificates needed for bank educational loans or passport verification.", "Document retrieval"},
					{"No Due Certificate Format", "Sign-off clearance checklist required from library, hostel, lab, and finance departments prior to semester end examinations.", "Document retrieval"},
					{"Bus Pass Renewal Application Guide", "Step-by-step verification guidelines and forms for college transport concession bus passes through the administrative desk.", "Document retrieval"},
					{"Transcript Request Application Form", "Standard application format required for obtaining official semester transcripts and grade mark sheets for higher studies.", "Document retrieval"},
					{"Hostel Leave & Outpass Application", "Official form required for weekend hostel outings and emergency home visit permissions signed by the warden.", "Document retrieval"},
					{"Consolidated Grade Sheet Duplicate Form", "Procedure and application form to request duplicate consolidated statement of grades in case of loss or damage.", "Document retrieval"}
			};

			for (String[] item : campusDatabase) {
				Document doc = new Document();
				doc.setTitle(item[0]);
				doc.setContent(item[1]);
				doc.setCategory(item[2]);
				repository.save(doc);
			}
		};
	}
}