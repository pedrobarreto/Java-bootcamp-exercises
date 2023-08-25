package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * The type Professional controller.
 */
@Controller
@Component
@Path("/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService professionalService;

  /**
   * Gets all professionals.
   *
   * @return the all professionals
   */
  @GET
  @Path("/all")
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    if (professionalService.getAllProfessionals().isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).entity(
              new ApplicationError("Nenhum registro foi encontrado!", Response.Status.NOT_FOUND))
          .build();
    }
    return Response.status(Response.Status.OK)
        .entity(professionalService.getAllProfessionals()).build();
  }


  /**
   * Add professional professional.
   *
   * @param professional the professional
   * @return the professional
   */
  @POST
  @Path("/add")
  @Consumes("application/json")
  @Produces("application/json")
  public Response insert(@Valid @RequestBody Professional professional) {
    if (professional.getId() != null) {
      return Response.status(Response.Status.BAD_REQUEST).entity(
              new ApplicationError("Não é permitido inserir novos registros com ID explícito",
                  Response.Status.BAD_REQUEST))
          .build();
    }
    professionalService.addProfessional(professional);
    return Response.status(Response.Status.CREATED).entity("Inserido").build();

  }

  /**
   * Edit professional professional.
   *
   * @param id           the id
   * @param professional the professional
   * @return the professional
   */
  @PUT
  @Path("/edit/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional professional) {
    if (professionalService.editProfessional(id, professional)) {
      String strId = String.valueOf(id);
      return Response.status(Response.Status.OK).entity("ID [" + strId + "] atualizado").build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(
              new ApplicationError("Não é possível editar, o ID informado não existe",
                  Response.Status.NOT_FOUND
                  ))
          .build();
    }
  }

  /**
   * Delete professional.
   *
   * @param id the id
   */
  @DELETE
  @Path("/delete/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    if (professionalService.deleteProfessional(id)) {
      String strId = String.valueOf(id);
      return Response.status(Response.Status.OK).entity("ID [" + strId + "] removido").build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(
              new ApplicationError("Não é possível deletar, o ID informado não existe",
                  Response.Status.NOT_FOUND))
          .build();
    }

  }

}
