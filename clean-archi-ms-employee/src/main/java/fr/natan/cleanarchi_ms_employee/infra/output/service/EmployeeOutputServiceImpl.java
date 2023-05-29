package fr.natan.cleanarchi_ms_employee.infra.output.service;

import fr.natan.cleanarchi_ms_employee.domain.entity.Employee;
import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.EmployeeNotFoundException;
import fr.natan.cleanarchi_ms_employee.domain.ports.output.EmployeeOutputService;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.ProjectModel;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services.AddressServiceProxy;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services.ProjectServiceProxy;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeDto;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeModel;
import fr.natan.cleanarchi_ms_employee.infra.output.mapper.EmployeeMapper;
import fr.natan.cleanarchi_ms_employee.infra.output.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeOutputServiceImpl implements EmployeeOutputService {
    private final EmployeeRepository employeeRepository;
    private final AddressServiceProxy addressServiceProxy;
    private final ProjectServiceProxy projectServiceProxy;
    public EmployeeOutputServiceImpl(EmployeeRepository employeeRepository, @Qualifier("address-service-proxy") AddressServiceProxy addressServiceProxy,
                                     ProjectServiceProxy projectServiceProxy) {
        this.employeeRepository = employeeRepository;
        this.addressServiceProxy = addressServiceProxy;
        this.projectServiceProxy = projectServiceProxy;
    }
    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeModel> employeesModel = employeeRepository.findByOrderByHireDateDesc();
        return employeesModel
                .stream()
                .map(EmployeeMapper::mapEmployeeModelToClass)
                .toList();
    }
    @Override
    public Employee createEmployee(Employee employee){
        EmployeeModel employeeModel = EmployeeMapper.mapClassToModel(employee);
        EmployeeModel persistedEmployee = employeeRepository.save(employeeModel);

        return EmployeeMapper.mapEmployeeModelToClass(persistedEmployee);
    }
    @Override
    public AddressModel getAddressByID(Long addressID) {
        return addressServiceProxy.getAddressById(addressID);
    }
    @Override
    public List<Employee> getEmployeeByInfo(EmployeeDto employeeDto) {
        List<EmployeeModel> employeeModels = employeeRepository.findByFirstnameAndLastnameAndAddressID(
                employeeDto.getFirstname(), employeeDto.getLastname(), employeeDto.getAddressID());

        return employeeModels.stream()
                .map(EmployeeMapper::mapEmployeeModelToClass)
                .toList();
    }
    @Override
    public Optional<Employee> getEmployeeByID(String employeeID) throws EmployeeNotFoundException {
        EmployeeModel employeeModel = employeeRepository.findById(employeeID).orElseThrow(
                EmployeeNotFoundException::new
        );
        return Optional.of(EmployeeMapper.mapEmployeeModelToClass(employeeModel));
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeModel employeeModel = EmployeeMapper.mapClassToModel(employee);
        EmployeeModel persistedEmployee = employeeRepository.save(employeeModel);
        return EmployeeMapper.mapEmployeeModelToClass(persistedEmployee);
    }
    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(EmployeeMapper.mapClassToModel(employee));
    }

    @Override
    public List<Employee> getEmployeesLivingAtGivenAddress(Long addressID) {
        List<EmployeeModel> employeeModels = employeeRepository.findByAddressID(addressID);
        return employeeModels
                .stream()
                .map(EmployeeMapper::mapEmployeeModelToClass)
                .toList();
    }

    @Override
    public List<ProjectModel> getProjectsAssignedToEmployee(String employeeID) {
        return projectServiceProxy.getProjectsAssignedToEmployee(employeeID);
    }
}
