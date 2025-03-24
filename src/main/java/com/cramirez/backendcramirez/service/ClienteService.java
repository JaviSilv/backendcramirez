package com.cramirez.backendcramirez.service;

import com.cramirez.backendcramirez.dto.ClienteDTO;
import com.cramirez.backendcramirez.entity.Cliente;
import com.cramirez.backendcramirez.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final OperarioRepository operarioRepository;
    private final PrefijotelefonicoRepository prefijotelefonicoRepository;
    private final IdentificacionRepository identificacionRepository;
    private final EstadoCivilRepository estadoCivilRepository;
    private final OcupacionRepository ocupacionRepository;
    private final NacionalidadRepository nacionalidadRepository;
    private final ResidenciaRepository residenciaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ProvinciaRepository provinciaRepository;
    private final DistritoRepository distritoRepository;


    @Autowired
    public ClienteService(ClienteRepository clienteRepository, OperarioRepository operarioRepository, PrefijotelefonicoRepository prefijotelefonicoRepository, IdentificacionRepository identificacionRepository, EstadoCivilRepository estadoCivilRepository, OcupacionRepository ocupacionRepository, NacionalidadRepository nacionalidadRepository, ResidenciaRepository residenciaRepository, DepartamentoRepository departamentoRepository, ProvinciaRepository provinciaRepository, DistritoRepository distritoRepository) {
        this.clienteRepository = clienteRepository;
        this.operarioRepository = operarioRepository;
        this.prefijotelefonicoRepository = prefijotelefonicoRepository;
        this.identificacionRepository = identificacionRepository;
        this.estadoCivilRepository = estadoCivilRepository;
        this.ocupacionRepository = ocupacionRepository;
        this.nacionalidadRepository = nacionalidadRepository;
        this.residenciaRepository = residenciaRepository;
        this.departamentoRepository = departamentoRepository;
        this.provinciaRepository = provinciaRepository;
        this.distritoRepository = distritoRepository;
    }


    // Guardar un nuevo cliente
    public ClienteDTO guardarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertirA_Entidad(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return convertirA_DTO(clienteGuardado);
    }

    // Obtener todos los clientes
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::convertirA_DTO)
                .collect(Collectors.toList());
    }

    // Obtener cliente por ID
    public ClienteDTO obtenerClientePorId(int id) {
        return clienteRepository.findById(id)
                .map(this::convertirA_DTO)
                .orElse(null);
    }

    // Obtener el último ID de cliente generado
    public Integer obtenerUltimoIdCliente() {
        return clienteRepository.findTopByOrderByIdClienteDesc()
                .map(Cliente::getIdCliente)
                .orElse(null);
    }

    public List<ClienteDTO> obtenerClientesPorOperario(int idOperario) {
        System.out.println("ID Operario recibido en el backend: " + idOperario);

        List<Cliente> clientes = clienteRepository.findByIdOperario(idOperario);
        System.out.println("Número de clientes encontrados: " + clientes.size());

        return clientes.stream()
                .map(this::convertirA_DTO)
                .collect(Collectors.toList());
    }


    // Actualizar cliente
    public ClienteDTO actualizarCliente(int id, ClienteDTO clienteDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setIdEstadoCivil(clienteDTO.getIdEstadoCivil());
                    cliente.setIdNacionalidad(clienteDTO.getIdNacionalidad());
                    cliente.setIdIdentificacion(clienteDTO.getIdIdentificacion());
                    cliente.setIdOcupacion(clienteDTO.getIdOcupacion());
                    cliente.setIdResidencia(clienteDTO.getIdResidencia());
                    cliente.setNombresApellidos(clienteDTO.getNombresApellidos());
                    cliente.setDireccion(clienteDTO.getDireccion());
                    cliente.setCorreoElectronico(clienteDTO.getCorreoElectronico());
                    cliente.setIdPrefijo(clienteDTO.getIdPrefijo());
                    cliente.setCelularCliente(clienteDTO.getCelularCliente());
                    cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
                    cliente.setIdDepartamento(clienteDTO.getIdDepartamento());
                    cliente.setIdProvincia(clienteDTO.getIdProvincia());
                    cliente.setIdDistrito(clienteDTO.getIdDistrito());
                    cliente.setIdOperario(clienteDTO.getIdOperario());
                    return convertirA_DTO(clienteRepository.save(cliente));
                })
                .orElse(null);
    }

    // Eliminar cliente
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }

    // Conversión de Cliente a ClienteDTO
    private ClienteDTO convertirA_DTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdEstadoCivil(cliente.getIdEstadoCivil());
        dto.setIdIdentificacion(cliente.getIdIdentificacion());
        dto.setIdNacionalidad(cliente.getIdNacionalidad());
        dto.setIdOcupacion(cliente.getIdOcupacion());
        dto.setIdResidencia(cliente.getIdResidencia());
        dto.setIdOperario(cliente.getIdOperario());
        dto.setIdPrefijo(cliente.getIdPrefijo());
        dto.setNombresApellidos(cliente.getNombresApellidos());
        dto.setDireccion(cliente.getDireccion());
        dto.setCorreoElectronico(cliente.getCorreoElectronico());
        dto.setCelularCliente(cliente.getCelularCliente());
        dto.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
        dto.setIdDepartamento(cliente.getIdDepartamento());
        dto.setIdProvincia(cliente.getIdProvincia());
        dto.setIdDistrito(cliente.getIdDistrito());

        dto.setOperario(obtenerTexto(operarioRepository.findById(cliente.getIdOperario()), "TipoOperario"));
        dto.setPrefijoPais(obtenerTexto(prefijotelefonicoRepository.findById(cliente.getIdPrefijo()), "PrefijoPais"));
        dto.setDocumentoIdentificacion(obtenerTexto(identificacionRepository.findById(cliente.getIdIdentificacion()), "DocumentoIdentificacion"));
        dto.setEstadoCivil(obtenerTexto(estadoCivilRepository.findById(cliente.getIdEstadoCivil()), "EstadoCivil"));
        dto.setOcupacion(obtenerTexto(ocupacionRepository.findById(cliente.getIdOcupacion()), "NombreOcupacion"));
        dto.setNacionalidad(obtenerTexto(nacionalidadRepository.findById(cliente.getIdNacionalidad()), "NombreNacionalidad"));
        dto.setResidencia(obtenerTexto(residenciaRepository.findById(cliente.getIdResidencia()), "Residencia"));
        dto.setDepartamento(obtenerTexto(departamentoRepository.findById(cliente.getIdDepartamento()), "NombreDepartamento"));
        dto.setProvincia(obtenerTexto(provinciaRepository.findById(cliente.getIdProvincia()), "NombreProvincia"));
        dto.setDistrito(obtenerTexto(distritoRepository.findById(cliente.getIdDistrito()), "NombreDistrito"));

        return dto;
    }

    // Conversión de ClienteDTO a Cliente
    private Cliente convertirA_Entidad(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setIdEstadoCivil(dto.getIdEstadoCivil());
        cliente.setIdNacionalidad(dto.getIdNacionalidad());
        cliente.setIdIdentificacion(dto.getIdIdentificacion());
        cliente.setIdResidencia(dto.getIdResidencia());
        cliente.setIdOcupacion(dto.getIdOcupacion());
        cliente.setNombresApellidos(dto.getNombresApellidos());
        cliente.setDireccion(dto.getDireccion());
        cliente.setIdPrefijo(dto.getIdPrefijo());
        cliente.setIdOperario(dto.getIdOperario());
        cliente.setCorreoElectronico(dto.getCorreoElectronico());
        cliente.setCelularCliente(dto.getCelularCliente());
        cliente.setNumeroIdentificacion(dto.getNumeroIdentificacion());
        cliente.setIdDepartamento(dto.getIdDepartamento());
        cliente.setIdProvincia(dto.getIdProvincia());
        cliente.setIdDistrito(dto.getIdDistrito());
        return cliente;
    }

    private String obtenerTexto(Optional<?> entidad, String campo) {
        return entidad.map(e -> {
            try {
                return e.getClass().getMethod("get" + campo).invoke(e).toString();
            } catch (Exception ex) {
                return null;
            }
        }).orElse(null);
    }

}
