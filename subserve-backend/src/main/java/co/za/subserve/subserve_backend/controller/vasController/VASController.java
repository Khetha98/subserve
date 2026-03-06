package co.za.subserve.subserve_backend.controller.vasController;



import co.za.subserve.subserve_backend.dto.request.ServiceRequestDTO;
import co.za.subserve.subserve_backend.service.vasService.VASService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vas")
@RequiredArgsConstructor
public class VASController {

    private final VASService vasService;

    @PostMapping("/print")
    public String requestPrinting(@RequestBody ServiceRequestDTO request) {
        return vasService.requestPrinting(request);
    }

    @PostMapping("/scan")
    public String requestScanning(@RequestBody ServiceRequestDTO request) {
        return vasService.requestScanning(request);
    }

    @PostMapping("/photocopy")
    public String requestPhotocopy(@RequestBody ServiceRequestDTO request) {
        return vasService.requestPhotocopy(request);
    }

    @PostMapping("/home-affairs-booking")
    public String bookHomeAffairs(@RequestBody ServiceRequestDTO request) {
        return vasService.bookHomeAffairs(request);
    }

    @PostMapping("/psira-booking")
    public String bookPSIRA(@RequestBody ServiceRequestDTO request) {
        return vasService.bookPSIRA(request);
    }

    @PostMapping("/software-request")
    public String softwareRequest(@RequestBody ServiceRequestDTO request) {
        return vasService.softwareRequest(request);
    }

}
