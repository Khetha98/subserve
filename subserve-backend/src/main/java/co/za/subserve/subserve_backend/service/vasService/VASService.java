package co.za.subserve.subserve_backend.service.vasService;

import co.za.subserve.subserve_backend.dto.request.ServiceRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class VASService {

    public String requestPrinting(ServiceRequestDTO request) {

        // store request in DB
        // send notification
        // queue job if needed

        return "Printing request received";
    }

    public String requestScanning(ServiceRequestDTO request) {
        return "Scanning request received";
    }

    public String requestPhotocopy(ServiceRequestDTO request) {
        return "Photocopy request received";
    }

    public String bookHomeAffairs(ServiceRequestDTO request) {
        return "Home Affairs booking submitted";
    }

    public String bookPSIRA(ServiceRequestDTO request) {
        return "PSIRA booking submitted";
    }

    public String softwareRequest(ServiceRequestDTO request) {
        return "Software request submitted";
    }

}